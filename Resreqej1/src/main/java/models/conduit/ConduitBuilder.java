package models.conduit;

public class ConduitBuilder {

    private User_conduit user;
    private ConduitBuilder(){
        user = new User_conduit();
    }

    public static ConduitBuilder cUser (){
        return new ConduitBuilder();
    }

    public ConduitBuilder password(String password){
        this.user.setPassword(password);
        return this;
    }

    public ConduitBuilder email(String email){
        this.user.setEmail(email);
        return this;
    }

    public User_conduit build(){
        return user;
    }

}
