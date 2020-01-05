package RestAPI;

import Entity.InsurancePackage;
import Model.ModelCar;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;

@Path("/")
public class ServiceInsurance {
    @Context
    UriInfo uri;
    @Context
    Request request;
    @GET
    @Path("/getlistpackage")
    @Produces(MediaType.APPLICATION_JSON)
    public List<InsurancePackage> getPackageList1(){
        ModelCar mc= new ModelCar();
        return mc.getPackageList1();
    }

    @GET
    @Path("/getpackage/{IDInsurance}")
    @Produces(MediaType.APPLICATION_JSON)
    public InsurancePackage getPackgebyip(@PathParam("IDInsurance") int IDInsurance){
        ModelCar mc = new ModelCar();
        return mc.getPackgebyip(IDInsurance);
    }

    @POST
    @Path("/insertpackage")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes({MediaType.APPLICATION_JSON})
    public Response addPackage (InsurancePackage insurancePackage){
        ModelCar mc= new ModelCar();
        mc.addPackage(insurancePackage);
        return Response.ok(insurancePackage).build();
    }

    @PUT
    @Path("/updatepackage")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updatepackage(InsurancePackage insurancePackage){
        ModelCar mc= new ModelCar();
        mc.updatepackage(insurancePackage);
        return Response.ok(insurancePackage).build();
    }

    @DELETE
    @Path("/deletepackage/{IDInsurance}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delpackage(@PathParam("IDInsurance") int IDInsurance){
        ModelCar mc= new ModelCar();
        InsurancePackage insurancePackage=mc.getPackgebyip(IDInsurance);
        mc.delpackage(insurancePackage);
        return Response.ok(insurancePackage).build();
    }
}
