package models;

public class UserRequestBuilder {


    //creamos builder para la organizacion de codigo y ademas realizamos serializacion y des serializacion.
    //serializacion: convertir de JSON a POJO
    //des_serializacion: convertir de POJO A JSON

    private Data data;
    private UserRequestBuilder(){
        data = new Data();
    }

    public static UserRequestBuilder aUser (){
        return new UserRequestBuilder();
    }

    public UserRequestBuilder password(String password){
        this.data.setPassword(password);
        return this;
    }

    public UserRequestBuilder email(String email){
        this.data.setEmail(email);
        return this;
    }

    public Data build(){
        return data;
    }

}
