import java.util.*;

public class GameLogic {
    public String[][] board;
    int row,col,bombs,safe;
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
       display(board);

       startGame(board,location);
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

            //checks
            if (locations.contains(click)) {
                board[loc[0]][loc[1]] = "X";
                gameOver();
                return;
            }
            if (board[loc[0]][loc[1]].equals("E")) {
                if (findAdj(board, loc[0], loc[1]) == 0) {
                    board[x][y] = String.valueOf(findAdj(board, loc[0], loc[1]));
                } else {
                    BFS(board, x, y);
                }
            }
            display(board);
        }
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
                for(int[] dir:directions){
                    int nx=dir[0]+loc[0];
                    int ny=dir[1]+loc[1];
                    if(nx<0||ny<0||nx>=row||ny>=col||visited.contains(nx+","+ny)){
                        continue;
                    }else{
                        if(board[nx][ny].equals("E")) {
                            this.safe--;
                            if (findAdj(board,nx,ny) == 0) {
                                board[nx][ny] = String.valueOf(findAdj(board, nx,ny));
                            } else {
                                board[nx][ny]="B";
                                visited.add(nx+","+ny);
                                q.add(nx+","+ny);
                            }
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
    public void gameOver(){
        System.out.println("BOOM!");
    }
    public void display(String[][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
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
}
