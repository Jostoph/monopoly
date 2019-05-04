public class GoToJailSquare extends Square {

    public GoToJailSquare() {
        super("Go To Jail", 29);
    }

    @Override
    public void landedOn(Player player) {
        player.getPiece().setLocation(Board.getInstance().getSquare(9));

        System.out.println(player + " goes to Jail");
    }
}
