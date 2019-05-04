public class Player {
    private String name;
    protected Piece piece;
    private int cash;

    public Player(String name) {
        this.name = name;
        this.piece = Piece.takePiece();
    }

    @Override
    public String toString() {
        return name;
    }

    public void takeTurn(Die[] dice) {
        int total = 0;
        for (Die die : dice) {
            die.roll();
            total += die.faceValue;
        }
        // System.out.println(name + " is on : " + piece.getLocation().getName());
        System.out.println(name + " got a " + dice[0].getFaceValue() + " and a " + dice[1].getFaceValue());

        Square oldLocation = piece.getLocation();
        Square newLocation = Board.getInstance().getSquare(oldLocation, total);

        // set new location
        piece.setLocation(newLocation);

        // perform action "landedOn" on the new square
        newLocation.landedOn(this);

        System.out.println(name + " is now on : " + piece.getLocation().getName() + "\n");
    }

    public void releasePiece() {
        Piece.release(this.piece);

        piece = null;
    }

    public Piece getPiece() {
        return piece;
    }

    public void addCash(int cash) {
        this.cash += cash;
    }

    public boolean reduceCash(int cash) {
        if (this.cash > cash) {
            this.cash -= cash;
            return true;
        } else {
            return false;
        }

    }

    public int getNetWorth() {
        return cash;
    }

}
