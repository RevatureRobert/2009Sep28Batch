package com.inter.threads;
/*
 * Threads
 * 		A thread is a subprocess away form the normal execution flow.
 * 
 * 		A thread will get its own stack, but shares the same heap with
 * 			all other threads. This is also known as multithreading.
 * 			(Thread concurrency, asynchronous operations)
 * 
 * 		Thread priority is an int between 1 and 10. This symbolizes the 
 * 			importance of the threads process. 10 is the highest priority
 * 			while 1 is the lowest. The deault priority is 5. The scheduler
 * 			determines which thread to run next by this priority.
 * 
 * 		The States of a Thread
 * 			New - newly created thread that has not begun execution.
 * 			Runnable - The thread is ready to be ran, determined by the
 * 				scheduler.
 * 			Blocked - Waiting on a synchronized resource to become available
 * 				to perform its operation.
 * 			Waiting - Waiting for another thread to complete execution for an 
 * 				undetermined amount of time.
 * 			Timed Waiting - Waiting for another thread to complete execution for
 * 				a determined amount of time.
 * 			Terminated - Has completed its execution and is ready to be
 * 				destroyed. 
 * 
 * 		How to create a thread
 * 			extend the Thread class in a custom thread class
 * 			Use an instance of the runnable interface in the constructor of the Thread
 * 
 * 		Multithreading issues (concurrency issues)
 * 			Stavartion - a situation where a thread with lower prioirity is not
 * 				allowed to run due to the other threads;
 * 			Deadlock - A situation where 2 threads have holds on resources. One thread 
 * 				needs the other's resource to complete its operation, and vice versa.
 * 				Since neither thread can gain access to the resource it needs, they are
 * 				in deadlock
 * 			Producer Consumer Problem - One thread produces data, the other consumes it.
 * 				When they are out of sync and working at differing speeds, this creates
 * 				data overflow or data starvation.
 * 
 * 		User Threads vs Daemon Threads
 * 			User Threads - Threads that we create with the purpose of joining the main thread
 * 
 * 			Daemon Threads - Background threads whose purpose is outside the main threads concern. 
 * 				it is not meant to rejoin the main thread.
 * 
 * 		Methods of threads
 * 			getters and setters for id, name, priority
 * 			interrupt - interrupts the thread
 * 			isAlive, isInterrupted, isDaemon, tests the state of the thread
 * 			join - wait for the thread to finish execution
 * 			start - starts the thread and begins execution
 * 
 * 		static methods
 * 			CurentThread - returns the current thread that is executing
 * 			sleep(long milliseconds) - causes the currently executing thread to
 * 				temporarily stop for a specified number of milliseconds.
 * */
public class ThreadNotes {

}
