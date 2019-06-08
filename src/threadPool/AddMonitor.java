package threadPool;

import java.util.List;
import java.util.Map;

public class AddMonitor {
	public synchronized void add(Map<Integer,List<List<Integer>>> OnesAndZeros,int idTask,List<List<Integer>> ListOneAndZeros) {
		OnesAndZeros.put(idTask,ListOneAndZeros);
	}
}
