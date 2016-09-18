package mooc.vandy.java4android.diamonds.logic;

import android.util.Log;
import mooc.vandy.java4android.diamonds.ui.OutputInterface;

/**
 * This is where the logic of this App is centralized for this assignment.
 * <p>
 * The assignments are designed this way to simplify your early
 * Android interactions.  Designing the assignments this way allows
 * you to first learn key 'Java' features without having to beforehand
 * learn the complexities of Android.
 */
public class Logic
       implements LogicInterface {
    /**
     * This is a String to be used in Logging (if/when you decide you
     * need it for debugging).
     */
    public static final String TAG = Logic.class.getName();

    /**
     * This is the variable that stores our OutputInterface instance.
     * <p>
     * This is how we will interact with the User Interface [MainActivity.java].
     * <p>
     * It is called 'out' because it is where we 'out-put' our
     * results. (It is also the 'in-put' from where we get values
     * from, but it only needs 1 name, and 'out' is good enough).
     */
    private OutputInterface mOut;

    /**
     * This is the constructor of this class.
     * <p>
     * It assigns the passed in [MainActivity] instance (which
     * implements [OutputInterface]) to 'out'.
     */
    public Logic(OutputInterface out){
        mOut = out;
    }

    /**
     * This is the method that will (eventually) get called when the
     * on-screen button labeled 'Process...' is pressed.
     */
    public void process(int size) {

        // TODO -- add your code here
        drawHorizontalLine(size);
        drawTopHalf(size);
        drawMiddleLine(size);
        drawBottomHalf(size);
        drawHorizontalLine(size);
    }

    public void drawHorizontalLine(int size)    //print top and bottom border lines
    {
        mOut.print('+');
        for(int col=1; col<=(size*2); col++)
        {
            mOut.print('-');
        }
        mOut.println('+');
    }

    public void drawTopHalf(int size)
    {
        for(int row=1; row <= (size-2)+1; row++)
        {
            mOut.print('|');
            for(int leftSpace = 1; leftSpace<=(size-row); leftSpace++)    //print spaces
            {
                mOut.print(' ');
            }
            mOut.print('/');
            for(int middleChar = 1; middleChar <= row*2-2; middleChar++)
            {
                if (row % 2 == 0)
                    mOut.print('-');    //if row is divisible by 2, print '-' otherwise print '='
                else
                    mOut.print('=');

            }
            mOut.print('\\');
            for(int rightSpace = 1; rightSpace<=(size-row); rightSpace++)    //print spaces
            {
                mOut.print(' ');
            }
            mOut.println('|');
        }
    }

    public void drawMiddleLine(int size)
    {
        mOut.print('|');
        mOut.print('<');
        for(int col = 1; col <= size*2-2; col++)
        {
            if(size % 2 == 0)
                mOut.print('-');
            else
                mOut.print('=');
        }
        mOut.print('>');
        mOut.println('|');
    }

    public void drawBottomHalf(int size)
    {
        for(int row=size-1; row >= 1; row--)
        {
            mOut.print('|');
            for(int leftSpace = 1; leftSpace<=size-row ; leftSpace++)    //print spaces
            {
                mOut.print(' ');
            }
            mOut.print('\\');
            for(int middleChar = 1; middleChar <= row*2-2; middleChar++)
            {
                if (row % 2 == 0)
                    mOut.print('-');    //if row is divisible by 2, print '-' otherwise print '='
                else
                    mOut.print('=');

            }
            mOut.print('/');
            for(int rightSpace = 1; rightSpace<=(size-row); rightSpace++)    //print spaces
            {
                mOut.print(' ');
            }
            mOut.println('|');
        }
    }
}
