import React from 'react';

/**
 * This is the first class componenet. Here we extend the React Component class
 * and overrid the render function. We return what is known as tsx(jsx).
 * It is typescript (javascript) with xml like syntax. 
 */
export class ClassClicker extends React.Component<any, any>{
    render() {
        return (
            <div>
                <button>this is from a class, yay!!</button>
            </div>
        );
    };
}