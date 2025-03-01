import java.util.*;

public class GameLogic {
    public String[][] board;
    int row,col,bombs,safe;

    int noOfFlag;

    public GameLogic(int row,int col){
       this.row=row;
       this.col=col;
       board=new String[row][col];
       bombs=(int)Math.sqrt(row*col);

       for(int i=0;i<row;i++){
           for(int j=0;j<col;j++){
               board[i][j]="E";
           }
       }
       Set<String> location=setBombs(row,col,bombs);
       safe=board.length*board[0].length-location.size();

       noOfFlag=location.size();

       display(board);
       System.out.println(location);
       System.out.println("No of safes:"+safe);

       //startGame(board,location);
    }
    public int[] breakDownCell(String s){
        String[] part=s.split(",");
        return new int[]{Integer.parseInt(part[0]),Integer.parseInt(part[1])};
    }
    public void startGame(String[][] board,Set<String> locations){
        Scanner input=new Scanner(System.in);

        while(this.safe!=0) {

            int x, y;
            System.out.println("ENTER-X:");
            x = input.nextInt();
            System.out.println("Enter-Y");
            y = input.nextInt();

            String click = x + "," + y;

            int[] loc = breakDownCell(click);
            System.out.println("The cell u clicked is "+loc[0]+" "+loc[1]+" and the cell is "+board[loc[0]][loc[1]]);

            if(checkBomb(click,locations)){return;}


            if (board[loc[0]][loc[1]].equals("E")) {
                int count=findAdj(board, loc[0], loc[1]);
                System.out.println(count+"is the adj COUNT FOR:"+loc[0]+":"+loc[1]);
                if ( count!=0) {
                    this.safe--;
                    board[x][y] = String.valueOf(count);
                } else {
                    BFS(board, x, y);
                }
            }
            display(board);
        }
        gameOver(true);
    }

    public Boolean checkBomb(String click, Set<String> locations) {
        if (locations.contains(click)) {
            int[] loc=breakDownCell(click);
            board[loc[0]][loc[1]] = "X";
            gameOver(false);
            return true;
        }
        return false;
    }

    private void BFS(String[][] board, int x, int y) {
        int[][] directions={{0,1},{1,0},{-1,0},{0,-1},{1,1},{-1,-1},{1,-1},{-1,1}};
        Set<String> visited=new HashSet<>();
        visited.add(x+","+y);
        Queue<String> q=new LinkedList<>();
        q.add(x+","+y);
        this.safe--;
        while(!q.isEmpty()){
            int l= q.size();
            for(int i=0;i<l;i++){
                String node=q.poll();
                int[] loc=breakDownCell(node);
                int count=findAdj(board,loc[0],loc[1]);
                if(count>0){
                    board[loc[0]][loc[1]]= String.valueOf(count);

                }
                else {
                    board[loc[0]][loc[1]]="B";
                    for (int[] dir : directions) {
                        int nx = dir[0] + loc[0];
                        int ny = dir[1] + loc[1];
                        if (nx < 0 || ny < 0 || nx >= row || ny >= col || visited.contains(nx + "," + ny)) {
                            continue;
                        } else {
                            this.safe--;
                            q.add(nx+","+ny);
                            visited.add(nx+","+ny);
                        }
                    }
                }
            }

        }

    }

    int findAdj(String[][] board,int x,int y){
        int count=0;
        int[][] directions={{0,1},{1,0},{-1,0},{0,-1},{1,1},{-1,-1},{1,-1},{-1,1}};
        for(int[] dir:directions){
            int nx=x+dir[0];
            int ny=y+dir[1];
            if(nx<0||ny<0||nx>=row||ny>=col){
                continue;
            }
            if(board[nx][ny].equals("M")){
                count++;
            }
        }
        return count;
    }
    public void gameOver(boolean b){
        if(!b){
            System.out.println("BOOM!");
        }
        else{
            System.out.println("U HAVE WON!!");
        }
    }
    public void display(String[][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println(this.safe);
    }
    public Set<String> setBombs(int row, int col, int bombs) {
        Random rand=new Random(42);
        Set<String> bombSet=new HashSet<>();
        while(bombs!=0){
            int x=rand.nextInt(row);
            int y=rand.nextInt(col);
            String new_string=x+","+y;
            if(!bombSet.contains(new_string)){
                bombSet.add(new_string);
                this.board[x][y]="M";
                bombs--;
            }
        }
        return bombSet;
    }

    public String[][] getBoard() {
        return this.board;
    }

    public void flagIt(int x, int y) {
        if(board[x][y].equals("E") || board[x][y].equals("M")){
            board[x][y]="F";
            noOfFlag--;
        }else if(board[x][y].equals("F")){
            board[x][y]="E";
            noOfFlag++;
        }
    }

    public Boolean revealCell(int x, int y) {
        if(board[x][y].equals("M")){
            return false;
        }
        if (board[x][y].equals("E")) {
            int count=findAdj(board,x,y);
            if ( count!=0) {
                this.safe--;
                board[x][y] = String.valueOf(count);
            } else {
                BFS(board, x, y);
            }
        }
        return true;
    }
}
