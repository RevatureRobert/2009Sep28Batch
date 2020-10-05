package com.inter.threads;
/*
 * 
 * Threads
 * 		
 * 		A thread is a subprocess away from the normal execution flow.
 * 
 * 		Each thread gets its own stack, but every thread shares the same heap with all other threads.
 * 			This is known as multithreading.  (aka thread concurrency, asynchronous operations, etc)
 * 
 * 		Thread priority is an integer between 1 and 10.  This symbolizes the importance of the thread's process,
 * 			where 10 is the highest and 1 is the lowest.  Default priority is 5.  The scheduler determines 
 * 			which thread to run next by checking priority. (Note, priorities are not unique values.  You can have
 * 			multiple threads with the same priority)
 * 
 * 		The states of a thread (thread lifecycle)
 * 			
 * 			New - newly created, has not begun to execute (Always 1st) - can go to any of the next 4 states next
 * 
 * 			Runnable - the thread is ready to be ran, determined by scheduler
 * 
 * 			Blocked - waiting on a synchronized resource to become available
 * 				to perform its operation (does not know how long it will be blocked)
 * 
 * 			Waiting - waiting on a different thread to complete execution for
 * 				an undetermined amount of time
 * 
 * 			TimedWaiting - waiting for another thread to complete execution for
 * 				a determined amount of time
 * 
 * 			Terminated - the thread completed its execution and is ready to be destroyed (Always Last)
 * 
 * 		How to create a thread
 * 			Extend the Thread class in a custom thread class
 * 			use an instance of the runnable interface in the constructor of the Thread (new Thread(customRunnable))
 * 
 * 		Multithreading issues (Concurrency issues)
 * 
 * 			Starvation - A situation where a thread with lower priority is not allowed to run due to
 * 				the other threads' priorities
 * 
 * 			DeadLock - A situation where 2 threads have holds on resources while one thread needs
 * 				the other's resources to complete its operation, and the other thread needs the first's
 * 				resources to let go of its holds.  Since neither thread gets access to resources, both are
 * 				in deadlock.  (Ways to resolve, plan ahead so one thread waits, or make a shared resource non-synchronous)
 * 
 * 			Producer Consumer Problem - One thread produces data that the other thread consumes.
 * 				When they are out of sync, and one thread works faster than the other, this causes either
 * 				data overflow or data starvation
 * 
 * 		User Threads vs Daemon Threads
 * 			
 * 			user threads - threads that we create with the purpose of joining the main thread
 * 			daemon threads - background threads whose purpose is outside the main thread's concern.(for example, the java garbage collector)
 * 				it is not meant to rejoin the main thread.
 * 
 * 		Methods of threads
 * 			getters and setters for id, name, priority
 * 			interrupt - interrupts the thread
 * 			isAlive, isInterrupted, isDaemon - test the state of the thread
 * 			join - wait for the thread to finish execution
 * 			start - start the thread and begin execution
 * 		
 * 		Static methods
 * 			currentThread - returns the current thread that is executing
 * 			sleep(long milliseconds) - causes the currently executing thread to temporarily stop for the specified amount of time
 * 			
 * 
 * In Java, threads are synchronous, it waits until the current thread to finish before moving on
 * Imagine making an http call.  Users shouldnt have to wait on that information while they do something else
 */
public class ThreadNotes {

}
