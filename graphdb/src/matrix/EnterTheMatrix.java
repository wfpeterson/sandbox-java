package matrix;

import org.neo4j.kernel.EmbeddedGraphDatabase;

public class EnterTheMatrix {

	public EnterTheMatrix() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		MatrixGraphBuilder builder = new MatrixGraphBuilder();
		MatrixGraphReader reader = new MatrixGraphReader();
		
		EmbeddedGraphDatabase graphdb = builder.build("matrix");
		reader.check1(graphdb);
		reader.check2(graphdb);
		reader.check3(graphdb);
		reader.check4(graphdb);
		graphdb = null;
		builder.destroy();

		System.out.println("Application completed.");
	}

}
