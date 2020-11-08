package constans;

public class Constans {

    public static class RunVeriable {
        public static String server = Servers.JSON_PLACE_HOLDER_URL;
        public static String path = "";
    }

    public static class Servers {
        public static String SWAPI_URL = "https://swapi.dev/";
        public static String JSON_PLACE_HOLDER_URL = "https://jsonplaceholder.typicode.com/";
    }

    public static class Path {
        public static String SWAPI_PATH = "api/";
    }

    public static class Actions {
        //swapi
        public static String SWAPI_GET_PEOPLE = "people/";

        //jsonplaceholder
        public static String JSON_PLACE_HOLDER_PUT = "posts/7";
    }

}
