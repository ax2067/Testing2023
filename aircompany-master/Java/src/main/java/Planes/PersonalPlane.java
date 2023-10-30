package Planes;

public class PersonalPlane  extends Plane {
    public PersonalPlane(Plane plane) {
        super(plane.model, plane.maxSpeed, plane.maxFlightDistance, plane.maxLoadCapacity);
    }
    
}
