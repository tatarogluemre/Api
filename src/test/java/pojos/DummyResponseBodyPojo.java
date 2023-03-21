package pojos;


import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DummyResponseBodyPojo {
//
//     "status": "success",
//             "data": {
//                 "employee_name": "Ali Can",
//                "employee_salary": 111111,
//                "employee_age": 23,
//                "profile_image": "Perfect image"
//    },
//            "message": "Successfully! Record has been updated."
//}
//

    private String status;
    private DummyDataPojo data;
    private String message;

    public DummyResponseBodyPojo() {
    }

    public DummyResponseBodyPojo(String status, DummyDataPojo data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DummyDataPojo getData() {
        return data;
    }

    public void setData(DummyDataPojo data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "DummyResponseBodyPojo{" +
                "status='" + status + '\'' +
                ", data=" + data +
                ", message='" + message + '\'' +
                '}';
    }
}
