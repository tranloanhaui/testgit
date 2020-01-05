package RestAPI;

import Entity.Car;
import Model.ModelCar;
import org.omg.CORBA.Request;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;

@Path("/")
public class Service {
    @Context
    UriInfo uri;
    @Context
    Request request;

    @Path("/getlistcar")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Car> getCarList() {
        ModelCar mc = new ModelCar();
        return mc.getCarList();
    }

    @Path("/getcarbynum/{NumberPlate}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Car getCarByNum(@PathParam("NumberPlate") String NumberPlate){
        ModelCar mc = new ModelCar();
        return mc.getCarByNum(NumberPlate);
    }

    @Path("/insertcar")
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response addCar(Car car){
        ModelCar mc= new ModelCar();
        mc.addCar(car);
        return Response.ok(car).build();
    }

    @Path("/updatecar")
    @PUT
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response updateCar(Car car){
        ModelCar mc= new ModelCar();
        mc.updateCar(car);
        return Response.ok(car).build();
    }

    @Path("/delete/{NumberPlate}")
    @DELETE
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response deletecar(@PathParam("NumberPlate") String NumberPlate){
       ModelCar mc = new ModelCar();
       Car car= mc.getCarByNum(NumberPlate);
       mc.delCar(car);
       return  Response.ok(car).build();
    }
}
