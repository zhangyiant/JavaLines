package srclines;

import java.io.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class GetLines
{
    public GetLines()
    {
    }

    public static int getLines(File directory,int depth)
    {
        int lines =0;
        FileFilter filter = new DirJavaFileFilter();
        File[] files = directory.listFiles(filter);
        for(int i=0;i<files.length;i++)
        {
//            for(int j=0;j<depth;j++)
//               System.out.print("  ");
//           System.out.println("accepted:"+files[i].getName());
           if(files[i].isDirectory())
            {

                lines += getLines(files[i],depth+1);
            }
            else
            {
                lines += getLines(files[i]);
            }
        }
        return lines;
    }

    public static int getLines(File file)
    {
        if(!file.isFile())
            return 0;
        int lines=0;
        try
        {
            FileInputStream in = new FileInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            while(reader.readLine() != null)
            {
                lines++;
            }
        }
        catch (Exception ex)
        {
        }

        System.out.println(file.getName()+":"+lines);

        return lines;
    }
    public static void main(String[] args)
    {
        if(args.length != 1)
            return;
        File file = new File(args[0]);

        if(!file.isDirectory())
            System.err.println("the input argument should be a directory");

        int totalLines = getLines(file,0);

        System.out.println("total lines:"+totalLines);

        return;
    }
}
