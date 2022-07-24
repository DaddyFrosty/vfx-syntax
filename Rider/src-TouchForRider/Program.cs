using System.Reflection.Metadata.Ecma335;

namespace TouchForRider;

public class Program
{
	public static void Main( string[] args )
	{
		var file = args[0];
		var handle = File.OpenHandle( file );
		File.SetLastWriteTimeUtc( args[0], File.GetLastWriteTimeUtc( args[0] ) );
		handle.Close();
	}
}