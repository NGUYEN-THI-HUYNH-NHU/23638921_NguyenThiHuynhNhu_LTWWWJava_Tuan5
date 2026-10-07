package com.example.tuan7_23638291_nguyenthihuynhnhu.resource;

import com.example.tuan7_23638291_nguyenthihuynhnhu.dto.request.DepartmentRequest;
import com.example.tuan7_23638291_nguyenthihuynhnhu.dto.response.DepartmentResponse;
import com.example.tuan7_23638291_nguyenthihuynhnhu.model.Department;
import com.example.tuan7_23638291_nguyenthihuynhnhu.service.DepartmentService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/department")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DepartmentResource {
    @Inject
    private DepartmentService departmentService;

    @GET
    public Response getAllDepartments() {
        List<DepartmentResponse> departments = departmentService.getAllDepartments();
        return Response.ok(departments).build();
    }

    @GET
    @Path("/{id}")
    public Response getDepartmentById(@PathParam("id") int id) {
        DepartmentResponse dept = departmentService.getDepartmentById(id);
        if (dept == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(dept).build();
    }

    @POST
    public Response addDepartment(DepartmentRequest request) {
        DepartmentResponse response = departmentService.addDepartment(request);
        return Response.status(Response.Status.CREATED).entity(response).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateDepartment(@PathParam("id") int id, DepartmentRequest request) {
        DepartmentResponse existing = departmentService.getDepartmentById(id);
        if (existing == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        Department dept = new Department();
        dept.setName(request.getName());
        DepartmentResponse response = departmentService.updateDepartment(id, dept);
        return Response.ok(response).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteDepartment(@PathParam("id") int id) {
        boolean deleted = departmentService.deleteDepartment(id);
        if (!deleted) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.noContent().build();
    }
}
