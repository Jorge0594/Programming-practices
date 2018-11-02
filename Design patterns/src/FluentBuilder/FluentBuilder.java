package FluentBuilder;

/*
    Description:

    Very useful whn we have a class with too many parameters. You will make your code easier understand.
 */

public class FluentBuilder {
    private String id;
    private String name;
    private String description;
    private int prize;

    private FluentBuilder(Builder builder) {
        setId(builder.id);
        setName(builder.name);
        setDescription(builder.description);
        setPrize(builder.prize);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrize() {
        return prize;
    }

    public void setPrize(int prize) {
        this.prize = prize;
    }

    private static final class Builder{
        private String id;
        private String name;
        private String description;
        private int prize;

        private Builder(){

        }

        public Builder id(String id){
            this.id = id;
            return this;
        }

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder description(String description){
            this.description = description;
            return this;
        }

        public Builder prize(int prize){
            this.prize = prize;
            return this;
        }

        public FluentBuilder build(){
            return new FluentBuilder(this);
        }
    }
}
