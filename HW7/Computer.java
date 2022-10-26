interface HardDrive {
    default void display(){
        System.out.println("This is the hard drive of your computer");
    }
}

interface DiskDrive {
    default void display(){
        System.out.println("This is the disk drive of your computer");
    }
}

interface RAM {
    default void display(){
        System.out.println("This is the RAM ive of your computer");
    }
}

interface Processor {
    default void display(){
        System.out.println("This is the processor of your computer");
    }
}

class Computer implements HardDrive, DiskDrive, RAM, Processor {

    boolean working = false;
    boolean has_viruses = false;
    int hard_drive_cap;

    Computer() {
        this.hard_drive_cap = 64;
    }

    Computer (int hard_drive_cap){
        this.hard_drive_cap = hard_drive_cap;
    }

    public void switchOn(){
        if(!this.working){
            this.working = true;
            System.out.println("You switched on your computer");
        } else {
            System.out.println("Your computer has already been switched on");
        }
    }

    public void switchOff(){
        if(this.working){
            this.working = false;
            System.out.println("You switched off your computer");
        } else {
            System.out.println("Your computer has already been switched off");
        }
    }

    public void virusesCheck(){
        int has_viruses = (int) Math.round(Math.random());

        if(has_viruses==0){
            this.has_viruses = false;
            System.out.println("You don't have viruses on your computer");
        }else{
            this.has_viruses = true;
            System.out.println("You have viruses on your computer");
        }
    }

    public int hadrDriveCap(){
        System.out.println("The capacity of your hard drive = " + this.hard_drive_cap);
        return hard_drive_cap;
    }


    @Override
    public void display() {
        HardDrive.super.display();
        DiskDrive.super.display();
        RAM.super.display();
        Processor.super.display();
    }

    public static void main(String[] args){
        Computer object1 = new Computer(1024);
        object1.switchOn();
        object1.switchOff();
        object1.virusesCheck();
        int capacity = object1.hadrDriveCap();
    }
}