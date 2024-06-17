package tests;

import org.testng.annotations.Test;
import services.Pet;


public class petSteps {

    Pet pet = new Pet();

    @Test(priority = 1)
    public void positiveCases() {

        pet.addANewPet("VALID-PET-1", 200 ,"id" ,"id");
        pet.uploadAnImage("VALID-PET-1", 200 ,"message","File uploaded to");
        pet.findPetsByStatus("pending", 200, "status", "pending");
        pet.findPetById("VALID-PET-1", 200 ,"name" ,"name");
        pet.updateAPet("UPDATED-PET-1", 200,"category","category");
        pet.updateWithFormData("VALID-PET-1", 200,"message", "id");
        pet.deleteAPet("VALID-PET-1", 200);
    }

       @Test (priority = 2)
       public void negativeCases() {

        pet.addANewPet("INVALID-PET-1", 500,"message","something bad happened" );
        pet.uploadAnImageNegative("INVALID-PET-2", 404);
        pet.findPetById("INVALID-PET-2", 404,"message","Pet not found");
        pet.updateAPet("INVALID-PET-1", 500, "message","something bad happened");
        pet.updateWithFormData("INVALID-PET-2", 404,"message","not found");
        pet.deleteAPet("INVALID-PET-2", 404);
    }
}