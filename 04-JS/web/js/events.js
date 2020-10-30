/*
    using addEventListener alows a third parameter for bubbling or capturing

    the event loop process...
        tool: latentflip.com/loupe/
        JS is single-threaded
            functionality remains in the same call stack until everything in the stack returns
                but asynchronous functions allow other operations to run while they're waiting
            setTimeout(function, time) sets the current block aside in the callback queue

    garbage collection
        when an object is removed, it and all its children are removed
        object heirarchy is like a tree; cut off a branch, and those ones are collected
    
    client-side storage
        Can see them in the developer console --> Application tab

        localStorage.setItem('key', 'value')
        localStorage.getItem('key') --> returns value

        Local Storage:      persists through many sessions
        Session:            Storage persists until the tab closes
        IndexedDB:          NoSQL database; save indices for your rows and communicate as JSONs
        Application Cache:  can automatically cache entire things like HTTP Responses; can Response items for specific URLs
        Cache Storage:      remove the network steps in delivering data; network is your biggest bottleneck

        The more you use client-side storage, the longer it'll take for the user to load the page
*/

console.log('\nConnected!');

function hey(){
    console.log('hey');
}

//module.exports = hey;

/**
 * 
 * @param {the event object} eventObj 
 * 
 * We can gather information about what happened and the
 * state of the page from the event object. The event object
 * will be passed in and will have several properties that
 * can give you insight into what was happening
 */
function printTheEventObject(eventObj){
    console.log(eventObj);
}