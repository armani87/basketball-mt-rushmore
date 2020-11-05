package org.wecancodeit.basketballmtrushmore;

public class Player {

    private long id;
    private String name;
    private String position;
    private String rings;


    public Long getId() { return id; }

    public String getName() { return name;}

    public String getPosition(){ return position;}

    public  String getRings(){ return rings;}

    public Player(long id, String name, String position, String rings){
        this.id=id;
        this.name=name;
        this.position=position;
        this.rings= rings;
    }

}
