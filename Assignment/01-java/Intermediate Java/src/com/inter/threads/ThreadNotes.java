package com.inter.threads;

/*
 * Threads
 * 
 * 			Everything in java in synchronized, so if one thing is running, the program will wait for it to finish
 * 			before moving on. Threads are a way around that
 * 			
 * 			A thread is a subprocess away form the normal execution flow
 * 	
 * 			Each thread gets it's own stack, but share the same heap with
 * 					all other threads. This is also known as multithreading or :
 * 					(Thread concurrency, concurrency, asynchronous operations).
 * 
 * 
 * 			Thread priority is an int between 1 and 10. This symbolizes the importance of 
 * 					that threads process. 10 is the highest priority, while 1 is the lowest priority. 
 * 					The default priority is 5. The scheduler determines which thread to run next
 * 					by this priority.
 * 					Multiple threads can have the same priority, the order then will be determined
 * 					by the scheduler
 * 
 * 			Threads have lifecycles ,and throughout their lifecycle, they have different states.
 * 			The order of the states is not guaranteed, only New and Terminated are the beginning and end. 
 * 			The thread may be in any other state between those two states.  
 * 			The states of a thread:
 * 			
 * 				New - newly created thread that has not begun execution
 * 
 * 				Runnable - the scheduler sees the thread as being ready to run
 * 
 * 				Blocked - waiting on synchronized resource to become available to perform 
 * 					it's operation. No timetable on when it will be unblocked
 * 
 * 				Waiting	- waiting for another thread to complete execution for an 
 * 					undetermined amount of time
 * 
 * 				TimedWaiting- waiting for another thread to complete execution for 	 
 * 					a determined amount of time. 
 * 
 * 				Terminated - the thread has completed its execution and is ready to be destroyed. 
 * 
 * 				
 * 		How to create a thread
 * 				extend the Thread class in a custom thread class
 * 				OR use an instance of the runnable interface in the constructor for the Trhead. 
 * 
 * 		multithreading issues (concurrency issues)
 * 			Starvation - A situation where a thread with lower priority is not allowed to run due to the
 * 				other threads' priorities. To bypass this, try to keep all resources around the same priority. 
 * 
 * 
 * 			Deadlock - A situation where 2 threads have holds on resources while one thread
 * 				needs the other's resources to complete it's operation, and the same goes for the other thread to let go of it's resource
 * 				Since neither thread can gain access to the resource it needs, they are in deadlock. To solve this,
 * 				preplan by making one thread wait, or by making one of the resources asynchronized.
 * 
 * 			Produce consumer problem - One thread produces data for another thread that consumes it. If
 * 				one thread is working faster(producing or consuming), then there will be a problem, either because
 * 				too much data(data overflow), or no data(data starvation). Check operational efficiency, if not the same, 
 * 				try to make it the same, or you can create another thread to help either thread work faster or slower. 
 * 
 * 
 * 		user threads vs daemon threads
 * 				
 * 			user threads - threads that we create with the purpose of joining the main thread
 * 
 * 			dameon threads - background threads whose purpose is outside the main threads concern. 
 * 				it is not meant to rejoin the main thread. 
 * 
 * 			
 * 		methods of threads
 * 			getters and setters for id, name, priority
 * 			interrupt - interrupts the thread
 * 			isAlive, isInterrupted,  isDaemon tests the state of the thread
 * 			join - wait for the thread to finish execution
 * 			start - starts the thread and begins execution
 * 
 * 		static methods
 * 			currentThread - returns the current thread that is executing
 * 			sleep(long milliseconds) causes the currently executing thread to 
 * 				temporarily stop for a specified number of milliseconds. 
 * 
 * 		**** Study states and multithreading problems, how to create a thread, and thread priority. and that threads
 * 			have their own stacks, and share a heap. ****
 * 				
 */

public class ThreadNotes {

}
