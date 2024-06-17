package services;

import helpers.ConfigReader;
import io.restassured.response.Response;
import restapi.RestApiPets;
public class Pet {

    ConfigReader readData = new ConfigReader();
    RestApiPets restMethod = new RestApiPets();

    public void uploadAnImage(String petName, int expectedCode , String responseData, String expectedData) {
        Response response= restMethod.postUploadIMage(readData.getTestData(petName), expectedCode);
        Object data;
        try {
            data=readData.getTestData(petName).get(expectedData);
        }catch (Throwable e){
            data=expectedData;
        }
        response.path(responseData).toString().equals(data);
    }

    public void uploadAnImageNegative(String petName, int expectedStatusCode){
        restMethod.postNotUploadIMage(readData.getTestData(petName),expectedStatusCode);
    }

    public void addANewPet(String petName, int expectedCode) {
      Response response= restMethod.postANewPet(readData.getTestData(petName), expectedCode);
    }

    public void addANewPet(String petName, int expectedCode, String responseData, String expectedData) {
        Response response= restMethod.postANewPet(readData.getTestData(petName), expectedCode);
        Object data;
        try {
            data=readData.getTestData(petName).get(expectedData);
        }catch (Throwable e){
            data=expectedData;
        }
        response.path(responseData).equals(data);
    }

    public void findPetById(String petName, int expectedCode) {
        restMethod.getById(readData.getTestData(petName), expectedCode);

    }

    public void findPetById(String petName, int expectedCode, String responseData, String expectedData) {
      Response response= restMethod.getById(readData.getTestData(petName), expectedCode);
        Object data;
        try {
            data=readData.getTestData(petName).get(expectedData);
        }catch (Throwable e){
            data=expectedData;
        }
        response.path(responseData).equals(data);

    }

    public void updateAPet(String petName, int expectedCode) {
        restMethod.updateAPet(readData.getTestData(petName), expectedCode);
    }
    public void updateAPet(String petName, int expectedCode, String responseData, String expectedData) {
        Response response=restMethod.updateAPet(readData.getTestData(petName), expectedCode);
        Object data;
        try {
            data=readData.getTestData(petName).get(expectedData);
        }catch (Throwable e){
            data=expectedData;
        }
        response.path(responseData).equals(data);

    }

    public void findPetsByStatus(String status, int expectedCode) {
        restMethod.getByStatus(status, expectedCode);
    }
    public void findPetsByStatus(String status, int expectedCode,String responseData, String expectedData) {
        Response response=restMethod.getByStatus(status, expectedCode);
        response.path(responseData).equals(expectedData);

    }

    public void updateWithFormData(String petName, int expectedCode) {
        restMethod.updateAPetWithFormData(readData.getTestData(petName), expectedCode);
    }

    public void updateWithFormData(String petName, int expectedCode, String responseData, String expectedData) {
        Response response=restMethod.updateAPetWithFormData(readData.getTestData(petName), expectedCode);
        Object data;
        try {
            data=readData.getTestData(petName).get(expectedData);
        }catch (Throwable e){
            data=expectedData;
        }
        response.path(responseData).equals(data);
    }

    public void deleteAPet(String petName, int expectedCode) {
        restMethod.deleteAPet(readData.getTestData(petName), expectedCode);
    }
}