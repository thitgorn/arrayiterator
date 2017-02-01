package ku.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Iterator for any array.
 * 
 * @author Thitiwat Thongbor
 *
 * @param <T>
 *            the type of thing in the ArrayIterato
 */
public class ArrayIterator<T> implements Iterator<T> {

	/** attribute for the array we want to iterate over */
	private T[] array;
	private int cursor;

	/**
	 * Initialize a new array iterator with the array to process.
	 * 
	 * @param array
	 *            is the array to iterate over
	 */
	public ArrayIterator(T[] array) {
		this.array = array;
		this.cursor = 0;
	}

	/**
	 * Return the next non-null element from array, if any.
	 * 
	 * @return the next non-null element in the array.
	 * @throws NoSuchElementException
	 *             if there are no more elements to return.
	 */
	@Override
	public T next() {
		if (hasNext()) {
			cursor++;
			return array[cursor - 1];
		} else
			throw new NoSuchElementException();
	}

	/**
	 * checking this array has more item or not. return true if there are any,
	 * otherwise , false.
	 */
	@Override
	public boolean hasNext() {
		for (int i = cursor; i < array.length; i++) {
			if (array[i] != null) {
				cursor = i;
				return true;
			}
		}
		return false;
	}

	/**
	 * remove the recent item in the array.
	 */
	@Override
	public void remove() {
		if (array[cursor - 1] != null) {
			array[cursor - 1] = null;
		} else
			throw new IllegalStateException();
	}
}
