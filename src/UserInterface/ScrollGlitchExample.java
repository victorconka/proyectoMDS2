package UserInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.HeadlessException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class ScrollGlitchExample extends JFrame
{
    public ScrollGlitchExample () throws HeadlessException
    {
        super ();

        final JPanel top = new JPanel ();
        top.setPreferredSize ( new Dimension ( 300, 50 ) );
        top.setBorder ( BorderFactory.createLineBorder ( Color.BLACK ) );
        add ( top, BorderLayout.NORTH );

        final JPanel panel = new JPanel ( new GridLayout ( 500, 1 ) );
        for ( int i = 0; i < 500; i++ )
        {
            panel.add ( new JButton ( "button" + i ) );
        }
        final JScrollPane scroll = new JScrollPane ( panel );
        scroll.setPreferredSize ( new Dimension ( 300, 300 ) );
        add ( scroll, BorderLayout.CENTER );

        final JPanel bottom = new JPanel ();
        bottom.setPreferredSize ( new Dimension ( 300, 50 ) );
        bottom.setBorder ( BorderFactory.createLineBorder ( Color.BLACK ) );
        add ( bottom, BorderLayout.SOUTH );

        setDefaultCloseOperation ( WindowConstants.EXIT_ON_CLOSE );
        pack ();
        setLocationRelativeTo ( null );
    }

    public static void main ( final String[] args )
    {
        SwingUtilities.invokeLater ( new Runnable ()
        {
            @Override
            public void run ()
            {
                new ScrollGlitchExample ().setVisible ( true );
            }
        } );
    }
}