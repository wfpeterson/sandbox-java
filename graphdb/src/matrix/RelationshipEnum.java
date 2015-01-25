package matrix;

import org.neo4j.graphdb.RelationshipType;

public enum RelationshipEnum implements RelationshipType {
	
	KNOWS,
	LOVES,
	CREATED,
	FIGHTS,
	MATRIX

}
