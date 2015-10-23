package srclines;

import java.io.FileFilter;
import java.io.File;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class DirJavaFileFilter
    implements FileFilter
{
    public DirJavaFileFilter()
    {
    }

    /**
     * Tests whether or not the specified abstract pathname should be included in
     * a pathname list.
     *
     * @param pathname The abstract pathname to be tested
     * @return <code>true</code> if and only if <code>pathname</code> should be
     *   included
     * @todo Implement this java.io.FileFilter method
     */
    public boolean accept(File pathname)
    {
 //       System.out.println(pathname.getName());

        if(pathname.isDirectory())
            return true;
        if(pathname.getName().endsWith("java"))
            return true;
        return false;
    }

}
