package collectionTransform;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * @author zouyang
 * @time 2016年12月1日 上午9:49:41
 * @description Array,List,Set,Map之间的相互转化
 */
public class CollectionTransformUtil {

	/**
	 * 数组转List
	 */
	public <T> List<T> arrayToList(T[] array){
		return Arrays.asList(array);
	}
	/**
	 * 数组转Set
	 */
	public <T> Set<T> arrayToSet(T[] array){
		Set<T> set = new HashSet<T>();
		for(T obj:array){
			set.add(obj);
		}
		return set;
	}
	/**
	 * List转数组
	 */
	public <T> T[] listToArray(List<T> list,T[] array){
		list.toArray(array);
		return array;
	}
	/**
	 * List转Set
	 */
	public <T> Set<T> listToSet(List<T> list){
		Set<T> set = new HashSet<T>();
		set.addAll(list);
		return set;
	}
	/**
	 * Set转数组
	 */
	public <T> T[] setToArray(Set<T> set,T[] array){
		set.toArray(array);
		return array;
	}
	/**
	 * Set转List
	 */
	public <T> List<T> setToList(Set<T> set){
		List<T> list = new ArrayList<T>();
		list.addAll(set);
		return list;
	}
	/**
	 * Map转数组
	 */
	public <E,T> T[] mapToArray(Map<E,T> map,T[] array,boolean flag){
		//根据flag判断将Map的key转化为数组还是讲value转化为数组
		if(flag){
			//flag为true将key转化为数组
			map.keySet().toArray(array);
			return array;
		}else{
			//flag为false将value转化为数组
			map.values().toArray(array);
			return array;
		}
	}
	
}
