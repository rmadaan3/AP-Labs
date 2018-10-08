// Name : Kanishk Rana
// Roll Number :  2017241

//Just uses basic java and emulate spotify app

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

interface users
{


    void streamSongs( int id, int songId, String dp, int artistId, int index );

    void details();
}

class Customer implements users
{
    private long id;
    private String name;
    private int subscription;
    private int songsPlayed;
    private int songsDownloaded;
    private int paymentDue;
    User temp;


    Customer(long id, String name, User c )
    {
        temp = c;
        this.id = id;
        this.name = name;
        this.subscription = 1;
    }

    @Override
    public void details()
    {
        System.out.println( this.toString() );
    }

    @Override
    public void streamSongs(int id, int songId, String dp, int artistId, int index) {

        int flag1= 0;
        int flag2 = 0;
        int customIndex = 0;

        for ( int i = 0; i < temp.customers.size(); i++ )
        {
            if ( temp.customers.get(i).id == id )
            {
                customIndex = i;
                break;
            }
        }
        if ( dp.equals("D") )
        {

            temp.customers.get(customIndex).setSongsDownloaded(  temp.customers.get(customIndex).getSongsDownloaded() + 1);

            if ( temp.customers.get(customIndex).getSongsDownloaded() <= temp.subcriptionArray[ temp.customers.get(customIndex).getSubscription()][1] )
            {
                temp.artists.get(index).setRoyalties( temp.artists.get(index).getRoyalties() + 20 );
            }
            else if( temp.customers.get(customIndex).getSongsDownloaded() - 1 == temp.subcriptionArray[ temp.customers.get(customIndex).getSubscription()][1])
            {
                flag1 = 1;
            }

        }
        else
                {
                    temp.customers.get(customIndex).setSongsPlayed(  temp.customers.get(customIndex).getSongsPlayed() + 1);

                    if ( temp.customers.get(customIndex).getSongsPlayed() <= temp.subcriptionArray[ temp.customers.get(customIndex).getSubscription()][0] )
                    {
                        temp.artists.get(index).setRoyalties( temp.artists.get(index).getRoyalties() + 5 );
                    }
                    else if( temp.customers.get(customIndex).getSongsPlayed() - 1 == temp.subcriptionArray[ temp.customers.get(customIndex).getSubscription()][0])
                    {
                        flag2 = 1;
                    }
                }

                if ( flag1 == 1 && flag2 == 1 )
                {
                    System.out.println("Cannot download or play more songs");
                }
                else if ( flag1 == 1 )
                {
                    System.out.println("Cannot download more songs");
                }
                else if ( flag2 == 1 )
                {
                    System.out.println("Cannot play more songs");
                }

    }

    public String toString()
    {
      String ret = this.getName() + " " + this.getId() + " " + this.getSubscription();
      return ret;
    }

    public long getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public int getSubscription()
    {
        return subscription;
    }

    public void setSubscription(int subscription) {
        this.subscription = subscription;
    }

    public int getSongsPlayed() {
        return songsPlayed;
    }

    public void setSongsPlayed(int songsPlayed) {
        this.songsPlayed = songsPlayed;
    }

    public int getSongsDownloaded() {
        return songsDownloaded;
    }

    public void setSongsDownloaded(int songsDownloaded) {
        this.songsDownloaded = songsDownloaded;
    }

    public int getPaymentDue() {
        return paymentDue;
    }

    public void setPaymentDue(int paymentDue) {
        this.paymentDue = paymentDue;
    }


}

class Artist implements users
{

    private long id;
    private String name;
    private long royalties;
    ArrayList<song> mySongs;
    User temp;

    Artist( long id, String name, User c )
    {
        temp = c;
        this.id = id;
        this.name = name;
        royalties = 0;
        mySongs = new ArrayList<>();
    }

    @Override
    public void streamSongs(int id, int songId, String dp, int artistId, int index) {

        if ( artistId != id )
        {
            if ( dp.equals("D") )
            {
                temp.artists.get(index).setRoyalties( temp.artists.get(index).getRoyalties() + 20 );
            }
            else
            {
                temp.artists.get(index).setRoyalties( temp.artists.get(index).getRoyalties() + 5 );
            }
        }
    }

    @Override
    public void details() {
        System.out.println(this.toSting());
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getRoyalties() {
        return royalties;
    }

    public void setRoyalties(long royalties) {
        this.royalties = royalties;
    }

    public String toSting()
    {

        String ret = this.getName() + " " + this.getId() + " : ";


        {
            for ( int i = 0; i < mySongs.size(); i++ )
            {
                ret = ret + mySongs.get(i).name + " ";
            }
        }
        return ret;
    }
}


class User
{
    ArrayList<Customer> customers;
    ArrayList<Artist> artists;
    static long counter;
    int[][] subcriptionArray;


    User()
    {
        customers = new ArrayList<>();
        artists = new ArrayList<>();
        counter = 1;
        subcriptionArray = new int[5][3];

        subcriptionArray[1][0] = 1;
        subcriptionArray[1][1] = 0;
        subcriptionArray[1][2] = 0;
        subcriptionArray[2][0] = 5;
        subcriptionArray[2][1] = 2;
        subcriptionArray[2][2] = 100;
        subcriptionArray[3][0] = 10;
        subcriptionArray[3][1] = 5;
        subcriptionArray[3][2] = 500;
        subcriptionArray[4][0] = 999999999;
        subcriptionArray[4][1] = 999999999;
        subcriptionArray[4][2] = 1000;
    }

    void _addArtist( String name )
    {
        Artist temp = new Artist( counter, name, this);
        artists.add(temp);
        counter++;
    }

    void _addCustomer( String name )
    {
        Customer temp = new Customer( counter, name, this);
        customers.add(temp);
        counter++;
    }

    void _changeSub( int id, int newSub )
    {
        int flag = 0;
        int index = 0;

        for ( int i = 0; i < customers.size(); i++ )
        {
            if ( customers.get(i).getId() == id )
            {
                flag = 1;
                index = i;
                break;
            }
        }

        if ( flag == 0 )
        {
            System.out.println("Enter a valid Customer ID");
        }
        else
        {
            if ( newSub <= 4)
            {

                if ( newSub >= customers.get(index).getSubscription() )
                {
                    customers.get(index).setSongsPlayed( subcriptionArray[ customers.get(index).getSubscription() ][0]);
                    customers.get(index).setSongsDownloaded( subcriptionArray[ customers.get(index).getSubscription() ][1]);
                    customers.get(index).setSubscription(newSub);

                }
                else
                {
                    if ( subcriptionArray[newSub][0] >= customers.get(index).getSongsPlayed() && subcriptionArray[newSub][1] >= customers.get(index).getSongsDownloaded())
                    {
                        customers.get(index).setSubscription(newSub);
                    }
                    else
                    {

                        System.out.println("Cannot change to the required subscription, please for your current subscription first");
                    }
                }
            }
            else
            {
                System.out.println("Enter a valid Subscription");
            }
        }
    }

    void _pendingRoyalties( int id )
    {
        int flag = -1;

        for ( int i = 0; i < artists.size(); i++ )
        {
            if ( artists.get(i).getId() == id )
            {
                flag = i;
                break;
            }
        }

        if ( flag == -1 )
        {
            System.out.println("Please enter a valid Artist ID ");
        }
        else
        {
            System.out.println( artists.get(flag).getRoyalties() );
            artists.get(flag).setRoyalties(0);
        }
    }

    void stream( int id, int songId, String dp, int ca )
    {

        if ( songId >= Songs.counter )
        {
            System.out.println("Please Enter a valid Song ID");
        }
        else
        {
            if ( ca == 0 )
            {
                int artistId = Songs.ids.get(songId);
                int index = -1;

                for ( int i = 0; i < artists.size(); i++ )
                {
                    if ( artists.get(i).getId() == artistId )
                    {
                        index = i;
                    }
                }

                artists.get(index).streamSongs( id, songId, dp, artistId, index);

            }
            else
            {

                int artistId = Songs.ids.get(songId);
                int index = -1;

                for ( int i = 0; i < artists.size(); i++ )
                {
                    if ( artists.get(i).getId() == artistId )
                    {
                        index = i;
                        break;
                    }
                }

                int customIndex = -1;

                for ( int i = 0; i < customers.size(); i++ )
                {
                    if ( customers.get(i).getId() == id )
                    {
                        customIndex = i;
                        break;
                    }
                }

                customers.get(customIndex).streamSongs( id, songId, dp, artistId, index);


            }
        }
    }

    void customCharges( int id )
    {
        int flag = checkCustomer(id);

        if ( flag > -1 )
        {
            int total = subcriptionArray[ customers.get(flag).getSubscription() ][2];
            System.out.println(total);
            customers.get(flag).setSongsDownloaded(0);
            customers.get(flag).setSongsPlayed(0);
        }
        else
        {
            System.out.println("Enter a valid Customer id");
        }
    }

    int checkCustomer( int id )
    {
        int flag = -1;


        for ( int i = 0; i < customers.size(); i++ )
        {
            if ( customers.get(i).getId() == id )
            {
                flag = i;

                break;
            }
        }
        return flag;
    }

    int checkArtist( int id )
    {
        int flag = -1;


        for ( int i = 0; i < artists.size(); i++ )
        {
            if ( artists.get(i).getId() == id )
            {
                flag = i;

                break;
            }
        }
        return flag;
    }

    void details( int id )
    {
        int flag = checkCustomer(id);

        if ( flag > -1 )
        {
            customers.get(flag).details();
        }
        else
        {
            flag = checkArtist(id);

            if ( flag > -1 )
            {
                artists.get(flag).details();
            }
            else
            {
                System.out.println("Please enter a valid user ID");
            }
        }
    }
}


class song
{
    int id;
    String name;

    song( int id, String name)
    {
        this.id = id;
        this.name = name;
    }
}

class Songs
{
    static HashMap<Integer,ArrayList<song>> songs;
    static HashMap<Integer, Integer> ids;
    static HashMap<Integer, String> sorting;

    User temp;
    static int counter;

    Songs( User c )
    {
        temp = c;
        songs = new HashMap<>();
        ids = new HashMap<>();
        sorting = new HashMap<>();
        counter = 1;
    }

    void _addSongs( int id, song[] array )
    {
        if ( songs.containsKey(id) )
        {
            int index = temp.checkArtist(id);

            for ( int i = 0; i < array.length; i++ )
            {
                songs.get(id).add(array[i]);
                ids.put( array[i].id, id);
                sorting.put( array[i].id, array[i].name );
                temp.artists.get(index).mySongs.add(array[i]);
            }
        }
        else
        {
            int flag = temp.checkArtist(id);

            if ( flag == -1 )
            {
                System.out.println("Enter a valid Artist id");
            }
            else
            {
                ArrayList<song> temp1 = new ArrayList<>();

                for ( int i = 0; i < array.length; i++ )
                {
                    temp1.add(array[i]);
                    ids.put( array[i].id, id );
                    sorting.put( array[i].id, array[i].name );
                    temp.artists.get(flag).mySongs.add(array[i]);
                }

                songs.put( id, temp1);
            }

        }
    }
}

public class Main
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        User spotifyUsers = new User();
        Songs songs = new Songs(spotifyUsers);
        int q = in.nextInt();

        while( q-- != 0 )
        {
            int query = in.nextInt();

            if ( query == 1 )
            {
                String type = in.next();

                if ( type.equals("A") )
                {
                    String name = in.next();
                    spotifyUsers._addArtist(name);
                    System.out.println(name + " " + ( User.counter - 1 ));
                }
                else if ( type.equals("C"))
                {
                    String name = in.next();
                    spotifyUsers._addCustomer(name);
                    System.out.println(name + " "+ ( User.counter - 1 ));
                }
                else
                {
                    System.out.println("To add an Artist enter A and the name of the artist");
                    System.out.println("Or to add a Customer add C and then the name of the Customer");
                }
            }
            else if ( query == 2 )
            {
                int id = in.nextInt();
                int sub = in.nextInt();
                spotifyUsers._changeSub(id,sub);
            }
            else if ( query == 3 )
            {
                int id = in.nextInt();
                int n = in.nextInt();

                song[] array = new song[n];

                for ( int i =0 ; i < n; i++ )
                {
                    String name = in.next();
                    song temp = new song( Songs.counter, name);
                    Songs.counter++;
                    array[i] = temp;
                }
                songs._addSongs(id,array);

                int flag = spotifyUsers.checkArtist(id);

                if ( flag > -1 )
                {
                    for ( int i = 0; i < n; i++ )
                    {
                        System.out.print( array[i].name + " " + array[i].id + " ");
                    }
                    System.out.println();
                }


            }
            else if ( query == 4 )
            {
                int id = in.nextInt();
                spotifyUsers._pendingRoyalties(id);
            }
            else if ( query == 5 )
            {
                int id = in.nextInt();
                int n = in.nextInt();
                int[] preferance = new int[n];

                int flag1 = spotifyUsers.checkArtist(id);

                int ca = 0;

                if ( flag1 > -1)
                {
                    ca = 0;
                }
                else
                {
                     flag1 = spotifyUsers.checkCustomer(id);

                     if ( flag1 > -1 )
                     {
                         ca =1;
                     }
                     else
                     {
                         System.out.println("Please input a valid user ID");
                     }
                }



                for ( int i = 0; i < n; i++ )
                {
                    int songId = in.nextInt();
                    String dp = in.next();
                    spotifyUsers.stream( id, songId, dp, ca);
                }

                int outOfBounds = 0;

                for ( int i = 0; i < n; i++ )
                {
                    preferance[i] = in.nextInt();

                    if ( i >= Songs.counter )
                    {
                        outOfBounds = 1;
                    }
                }

                if ( outOfBounds == 0 )
                {
                    for ( int i = 0; i < n; i++)
                    {
                        System.out.print( Songs.sorting.get( preferance[i] ) + " " );
                    }
                    System.out.println();
                }
            }
            else if ( query == 6 )
            {
                int id = in.nextInt();
                spotifyUsers.customCharges(id);
            }
            else if (  query == 7 )
            {

                int id = in.nextInt();
                spotifyUsers.details(id);
            }
            else
            {
                System.out.println("Wrong Input, Please enter a valid query");
            }
        }
    }
}
