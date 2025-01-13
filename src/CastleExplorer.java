public class CastleExplorer {

    private String ancientRunes = "z%nxt#%lh#@wsife#w#qr$mt*h!lho#gr&tw#sxrk^o#wl#tvqu!mf#*pzl#i#e!ksv#fe*$sioe#s#i#pmn#?*wt#bh#rzfhwie#xf#jntxo#h%nr#fue#*!orzs#jst#^*@";
    Dragon[] dragons;
    public static void main(String[] args) {
        CastleExplorer john = new CastleExplorer();
    }
    int RandInt(int upperBound){
        return (int)(upperBound*Math.random());
    }

    public CastleExplorer() {
        System.out.println("Welcome, brave knight! May your code be as strong as your sword!");
        dragons = new Dragon[50];
        for(int x=0;x<dragons.length;x++){
            dragons[x] = new Dragon(RandInt(90)+10,RandInt(450)+50);
        }
        displayDragons();
        System.out.println("It is "+checkFirePower()+" that two dragons have the same fire power.");
        System.out.println(decipher(ancientRunes));
    }
    void displayDragons(){
        for(Dragon d: dragons){
            d.printInfo();
        }
    }
    boolean checkFirePower(){
        boolean[] possibilities = new boolean[101];
        for(Dragon d: dragons){
            if(possibilities[d.getFirePower()]){
                return true;
            } else {
                possibilities[d.getFirePower()] = true;
            }
        }
        return false;
    }
    String decipher(String input){
        String english = "";
        String code = input;
        while(code.contains("#")){
            english+=code.charAt(code.indexOf("#")-1);
            code=code.substring(code.indexOf("#")+1);
        }
        return english;
    }

}
class Dragon{
    private int firePower;
    private int treasureGuarded;

    public Dragon(int firePower, int treasureGuarded) {
        this.firePower = firePower;
        this.treasureGuarded = treasureGuarded;
    }

    public int getFirePower() {
        return firePower;
    }

    public void setFirePower(int firePower) {
        this.firePower = firePower;
    }

    public int getTreasureGuarded() {
        return treasureGuarded;
    }

    public void setTreasureGuarded(int treasureGuarded) {
        this.treasureGuarded = treasureGuarded;
    }
    public void printInfo(){
        System.out.println("Fire power: "+firePower+". Treasure guarded: "+treasureGuarded+".");
    }
}