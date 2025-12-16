package edu.upc.dsa.services;

import edu.upc.dsa.services.dto.Event;
import edu.upc.dsa.services.dto.RegisterResponse;
import io.swagger.annotations.*;
import org.apache.log4j.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Api(value = "/events", description = "Events endpoints (dummy)")
@Path("/events")
@Produces(MediaType.APPLICATION_JSON)
public class EventsService {

    Logger logger = Logger.getLogger(EventsService.class);

    private List<Event> dummyEvents() {
        List<Event> events = new ArrayList<>();

        events.add(new Event(
                1,
                "https://cdn.pixabay.com/photo/2016/11/23/15/48/audience-1853662_1280.jpg",
                "Evento Black Friday",
                "Inventario especial de campaña",
                "20-12-2025",
                "21-12-2025"
        ));

        events.add(new Event(
                2,
                "https://cdn.pixabay.com/photo/2016/08/16/09/53/international-conference-1597531_1280.jpg",
                "Inventario Navidad",
                "Turnos extendidos y refuerzo",
                "22-12-2025",
                "24-12-2025"
        ));

        events.add(new Event(
                3,
                "https://cdn.pixabay.com/photo/2020/10/29/13/34/table-5696243_1280.jpg",
                "Formación Retail",
                "Sesión de onboarding",
                "26-12-2025",
                "26-12-2025"
        ));

        return events;
    }

    private boolean existsEvent(int id) {
        for (Event e : dummyEvents()) {
            if (e.getId() == id) return true;
        }
        return false;
    }

    @GET
    @ApiOperation(value = "List events (dummy)")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK", response = Event.class, responseContainer = "List")
    })
    public Response getEvents() {
        logger.info("GET /events - returning dummy events list");
        List<Event> events = dummyEvents();
        return Response.ok(new GenericEntity<List<Event>>(events) {}).build();
    }

    @POST
    @Path("/{id}/register")
    @ApiOperation(value = "Register to an event (dummy)")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK", response = RegisterResponse.class),
            @ApiResponse(code = 404, message = "Event not found", response = RegisterResponse.class)
    })
    public Response registerToEvent(@PathParam("id") int id) {
        logger.info("POST /events/" + id + "/register - register attempt");

        if (!existsEvent(id)) {
            logger.warn("POST /events/" + id + "/register - the event does not exist");
            RegisterResponse res = new RegisterResponse(false, "El evento " + id + " no existe");
            return Response.status(Response.Status.NOT_FOUND).entity(res).build();
        }

        logger.info("POST /events/" + id + "/register - registered OK (dummy)");
        RegisterResponse res = new RegisterResponse(true, "Usuario registrado en el evento " + id);
        return Response.ok(res).build();
    }
}
