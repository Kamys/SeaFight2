package hnkntoc.com.seafight2.Game;



import android.view.View;


import hnkntoc.com.seafight2.Activity.BattlefieldActivity;
import hnkntoc.com.seafight2.Game.Field.Cell;
import hnkntoc.com.seafight2.Game.Players.Player;

/**
 * Здесь происходит обработка событий боя
 */
public class Battlefield{

    private Player player1;
    private Player player2;
    private BattlefieldActivity battlefieldActivity;
    private int numberMoves;

    public Battlefield(Player player1, Player player2,BattlefieldActivity battlefieldActivity) {
        this.battlefieldActivity=battlefieldActivity;
        this.player1 = player1;
        this.player2 = player2;

        player1.setListnerListCell(new OnClickListenerField(player1));
        player2.setListnerListCell(new OnClickListenerField(player2));

    }

    /**
     * Начало боя.
     * @return false если бой не может быть начат.
     */
    public boolean startCombat(){
        player1.setMove(true);
        return true;
    }

    /**
     * Остоновка боя.
     * @return false если бой не может быть окончен.
     */
    public boolean stopCombat(){
        player1.setMove(false);
        player2.setMove(false);
        return true;
    }

    private void nextMove(){
        if(player1.getMove()){
            player1.setMove(false);
            player2.setMove(true);
        }else {
            player2.setMove(false);
            player1.setMove(true);
        }

    }

    /**
     * Метод вызывается после каждого хода
     * @param b если пришло false значит игрок промазал и право хода передаётся следующему игроку.
     *          если пришло true значит игрок попал и его ход продолжается.
     */
    public void movePlayer(boolean b){
        if(!b){
            nextMove();
        }
        player1.setMove(player1.getMove());
        player2.setMove(player2.getMove());

        if(player1.getHit()>=20){
            battlefieldActivity.next(player2);
        }

        if(player2.getHit()>=20){
            battlefieldActivity.next(player1);
        }
    }

    /**
     * Данный класс обрабатывает нажатия на поля одного из игроков
     */
    class OnClickListenerField implements View.OnClickListener{
        private Player player;

        public OnClickListenerField(Player player) {
            this.player = player;
        }

        /**
         *  Если игрок нажимает на клетку вызывается этот метод
         *  и вызывает у player метод hit;
         * @param view передаёт Cell на которое нажали.
         */
        @Override
        public void onClick(View view) {
            if(!player.getMove()) {
                Cell cell = (Cell) view;
                movePlayer(player.hit(cell.getColumns(), cell.getRows()));
            }
        }
    }

}
