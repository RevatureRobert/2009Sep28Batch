package com.inter.threads;

/*
 * Threads
 * 
 * 	A thread is a subprocess; the main thread is started when the program is started
 * 	A single thread has serial operation; it must complete its current process before it moves to the next process
 * 	A different thread may operate sychronously, allowing it to carry out actions while other threads are busy
 * 
 * 
 * A thread is typically used as a subprocess away from the normal process flow
 * Each thread gets its own stack, but all threads share the Heap. This is expressed as multithreading.
 * 		(thread concurrency, asynchronous operations)
 * 
 * 
 * Thread priority is an int between 1 and 10, symbolizing the importance of the thread's process.
 * 		10 is the highest priority, 1 is the lowest; 5 is default.
 * 		The scheduler determines which thread to run next by this priority.
 * 		If two threads have the same priority, the scheduler decides which to run first
 * 
 * Thread life cycle: Threads have a life cycle, and each thread can hold different states
 * 		NEW - Newly-created thread that has not begun execution
 * 		
 * 		RUNNABLE - Ready to be run by the thread scheduler
 * 		BLOCKED - Waiting to acquire a (synchronized) resource before continuing execution
 * 		WAITING - Waiting for another thread to complete execution, for an undetermined amount of time
 * 		TIMEDWAITING - Waiting for another thread to complete, for a predetermined amount of time
 * 		
 * 		TERMINATED - Has completed execution
 * 
 * 
 * How to create a thread
 * 		extend the Thread class
 * 			want to override the run() method to write out any logic, then run it using the start() method
 * 		use an instance of Runnable in the constructor of the Thread
 * 
 * 
 * Synchronous resources
 * 		Console is an example of this; multiple threads may attempt to access it at the same time
 * 		If a thread is waiting 
 * 		Synchronised keyword - Means only one thread may access this resource at a time
 * 
 * multithreading issues (concurrency issues)
 * 		Starvation - When a thread with lower priority is not able to run due to other threads' priorities
 * 		DeadLock - Thread A needs a resource from Thread B, and Thread B needs a resource from Thread A to continue
 * 		Producer/Consumer Problem - A data producer produces data faster or slower than it can be consumed
 * 
 * 
 * 
 * Runnable interface
 * 		new Thread(Runnable target) - applies run() implementation from the target runnable
 * 
 * 
 * User threads vs daemon threads
 * 		User threads - threads that we create with the purpose of joining the main thread
 * 		Daemon threads - background execution, outside of main; may keep running when the program isn't running
 * 			(EX: garbage collector)
 * 
 * 
 * 
 * Thread methods
 * 		getters and setters for id, name, priority
 * 		interrupt() - interrupts the thread
 * 		isAlive(), isInterrupted(), isDaemon() - test the state of the thread
 * 		join() - wait for the thread to finish execution
 * 		start() - starts the thread and begins execution
 * 
 * static methods
 * 		currentThread - returns the current thread that is executing
 * 		sleep(long ms) - causes the currently running thread to pause for the specified number of ms
 * 
 * 
 * 
 * QC WILL ASK ABOUT THREADS (multithreading issues and the states of a thread)
 */

public class ThreadNotes {

	public static void main(String[] args) {
		
		
	}

}
