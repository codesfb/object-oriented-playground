public class UserAccount {
    private String userName;
    private  String email;
    private Post[] timeLine = new Post[10];
    private Post[] myPosts = new Post[100];
    private UserAccount[] myFollowers = new UserAccount[100];
    private  UserAccount[] myFriends = new UserAccount[100];
    private int numOfMyposts;
    private int numOfMyFollowers;
    private int numOfTimeLine;
    private int numOfMyFriends;


    public UserAccount(String userName, String email){
        this.userName = userName;
        this.email = email;
    }

    public void publish(String quote) {
        Post newPost = new Post(this, quote);
        if (numOfMyposts < myPosts.length) {
            myPosts[numOfMyposts++] = newPost;
        }
        updateTimeLine(newPost);
        
    }

    public void updateTimeLine(Post newPost){
        //?? update my followers timeline ?
        for(int i = 0; i <numOfMyFollowers; i++) {
           myFollowers[i].addToTimeline(newPost);

        }

    }

    private void addToTimeline(Post newPost) {
        timeLine[numOfTimeLine % 10] = newPost;
        numOfTimeLine++;
    }

    public boolean delete(int postIdx){
        if (postIdx < 0 || postIdx >= numOfMyposts) return false;

        myPosts[postIdx] = myPosts[numOfMyposts - 1];
        myPosts[numOfMyposts - 1] = null;
        numOfMyposts--;

        return true;
    }

    public String showTimeLine(){
        StringBuilder string = new StringBuilder();
        string.append("Timeline:");
        for (int i = 0; i < timeLine.length; i++) {
           string.append("\n").append(timeLine[i]).append("\n");
        }
        return string.toString();
    };



    public String showMyPosts(){
        StringBuilder string = new StringBuilder();
        string.append("My Posts :");
        for (int i = 0; i < numOfMyposts; i++) {
            string.append("\n").append(myPosts[i]).append("\n");
        }
        return string.toString();
    }

    public String showMyFriends(){
        StringBuilder string = new StringBuilder();
        string.append("My friends:");
        for (int i = 0; i < numOfMyFriends; i++) {
            string.append("\n").append(myFriends[i]).append("\n");
        }
        return string.toString();
    };

    public void clapPost(int postIdx){
        if(postIdx >= 10 || postIdx < 0 || timeLine[postIdx]== null) return;
        timeLine[postIdx].claps();

    };

    public void booPost(int postIdx){
        if(postIdx >= 10 || postIdx < 0 || timeLine[postIdx]== null) return;
        timeLine[postIdx].boos();
    };
    public void acceptFollower(UserAccount newFollower){
        myFollowers[numOfMyFollowers++]= newFollower;
    }
    public void blockFollower(UserAccount newFollower){
        for (int i = 0; i < numOfMyFollowers; i++) {
            if (myFollowers[i].equals(newFollower)) {
                for (int j = i; j < numOfMyFollowers - 1; j++) {
                    myFollowers[j] = myFollowers[j + 1];
                }
                myFollowers[numOfMyFollowers - 1] = null;
                numOfMyFollowers--;
                return;
            }
        }
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }
}
