import java.lang.Exception;

public class FaceException extends Exception {
  public FaceException() {
    message = "No message.";
  }

  public FaceException(String m) {
    message = m;
  }

  public String message() {
    return message;
  }

  private String message;
}
