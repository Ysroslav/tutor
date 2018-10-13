package com.bodrov.spring.tutor.database.endpoint;

import com.bodrov.spring.tutor.database.entity.Department;
import com.bodrov.spring.tutor.database.service.DepartmentService;
import com.bodrov.spring.tutor.soap.department.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;
import java.util.logging.Logger;

@Endpoint
public class DepartmentEndpoint {

    @NotNull
    private final static Logger LOGGER = Logger.getLogger(DepartmentEndpoint.class.getSimpleName());

    @NotNull
    public final static String LOCATION_URI = "/soap/department";

    @NotNull
    public final static String PORT_TYPE_NAME = "DepartmentEndpointPort";

    @NotNull
    public final static String NAMESPACE = "http://bodrov.com/spring/tutor/soap/department";

    @Autowired
    private DepartmentService departmentService;

    @ResponsePayload
    @PayloadRoot(localPart = "pingRequest", namespace = NAMESPACE)
    public PingResponse ping(@RequestPayload final PingRequest request){
        final PingResponse response = new PingResponse();
        response.setSucces(true);
        return response;
    }

    @ResponsePayload
    @PayloadRoot(localPart = "testRequest", namespace = NAMESPACE)
    public TestResponse test(@RequestPayload TestRequest request){
        return new TestResponse();
    }

    @ResponsePayload
    @PayloadRoot(localPart = "getDepartmentRequest", namespace = NAMESPACE)
    public GetDepartmentResponse getDepartments(@RequestPayload final GetDepartmentRequest request){
        final GetDepartmentResponse response = new GetDepartmentResponse();
        try{
            final List<Department> departments = departmentService.findAll();
            for(Department department: departments){
                final DepartmentRecord departmentRecord = new DepartmentRecord();
                departmentRecord.setId(department.getId());
                departmentRecord.setDepartmentName(department.getDepartmentName());
                response.getRows().add(departmentRecord);
            }
        } catch(@NotNull final Exception e){
                LOGGER.severe(e.getMessage());
        }
        return response;
    }

    @ResponsePayload
    @PayloadRoot(localPart = "removeDepartmentRequest", namespace = NAMESPACE)
    public RemoveDepartmentResponse removeDepartment(@RequestPayload final RemoveDepartmentRequest request){
        final RemoveDepartmentResponse response = new RemoveDepartmentResponse();
        try{
            departmentService.deleteById(request.getId());
            response.setSucces(true);
        } catch(@NotNull final Exception e){
            response.setMessage(e.getMessage());
            response.setSucces(false);
        }
        return response;
    }

    @ResponsePayload
    @PayloadRoot(localPart = "createDepartmentRequest", namespace = NAMESPACE)
    public CreateDepartmentResponse createDepartment(@RequestPayload final CreateDepartmentRequest request){
        final CreateDepartmentResponse response = new CreateDepartmentResponse();
        try{
            final Department department = new Department();
            department.setId(request.getDepartmentName());
            department.setDepartmentName("New Department");
            departmentService.save(department);
            response.setSucces(true);
        } catch(@NotNull final Exception e){
            response.setMessage(e.getMessage());
            response.setSucces(false);
        }
        return response;
    }

}
