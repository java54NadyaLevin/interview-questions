package telran.interviews;

import java.util.LinkedHashMap;
import java.util.Map;

public class ConnectionPool {

	LinkedHashMap<Long, Integer> map;
	@SuppressWarnings("serial")
	public ConnectionPool(int size) {
		map = new 
				LinkedHashMap<>(10, 0.75f, true) {
			@Override
			protected boolean removeEldestEntry(Map.Entry<Long, Integer> entry) {
				return size() > size;
			}
		};
	}
public Connection getConnection(Connection connection) {
	boolean inPool = isInPool(connection.id());
	Connection newConnection = null;
	if(!inPool) {
		newConnection = new Connection(connection.id());
		map.put(newConnection.id(), Integer.valueOf(1));
	}

	return inPool ? connection : newConnection;
}
public boolean isInPool(long id) {
	return map.get(id) != null;
}
}
