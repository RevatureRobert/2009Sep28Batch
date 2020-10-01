package com.inter.threads;
/*
 * Threads
 * 
 * 		A thread is a subprocess away from the noraml execution flow.
 * 
 * 		A thread will get its own stack, but shares the same heap with 	
 * 			all other threads. This is also known as multithreading.
 * 			(thread concurrency, asynchronous operations)
 * 
 * 		Thread priority is an int between 1 and 10. This symbolizes the 
 * 			importance of the threads process. 10 is the highest while 1 
 * 			is the lowest. The default priority is 5. The scheduler determines
 * 			which thread to run next by this priority.
 * 
 * 		The states of a thread (thread lifecycle)
 * 
 * 			New - newly created thread that has not begun execution.
 * 
 * 			Runnable - the thread is ready to be ran, determined by the
 * 				scheduler.
 * 
 * 			Blocked - waiting on a synchronized resource to become available
 * 				to perform its operation
 * 
 * 			Waiting - waiting for another thread to complete execution for an
 * 				undetermined amount of time.
 * 
 * 			TimedWaiting - waiting for another thread to complete execution for 
 * 				a determined amount of time.
 * 
 * 			Terminated - has completed its execution
 * 
 * 		How to create a thread
 * 			extend the Thread class in a custom thread class
 * 
 * 		multithreading issues (concurrency issues)
 * 
 * 			Starvation - A situation where a thread with lower priority is not
 * 				allowed to run due to the other threads' priorities
 * 
 * 			DeadLock - A situation where 2 threads have holds on resources. one thread
 * 				needs the other's resource to complete its operation, and the same
 * 				goes for the other thread to let go of it's. Since neither thread
 * 				can gain access to the resource it needs, they are in deadlock.
 * 
 * 			Producer consumer problem - One thread produces data, the other consumes the information.
 * 				When they are out of sync and working faster than the other, this creates 
 * 				data overflow or data starvation.
 * 
 * 		
 */
public class ThreadNotes {

}
