//Written by Mia Dia
public interface QueueIT <T>
{
	public void enqueue(T aData);
	public T dequeue();
	public T peek();
	public void print();
}
