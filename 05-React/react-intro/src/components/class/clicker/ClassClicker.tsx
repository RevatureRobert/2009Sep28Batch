import React from 'react';

/**
 * This is out first class component. Here, we extend the React Component class
 * and override the render function. We return what is known as tsx (jsx). It
 * is typescript (javascript) with xml
 */
export class ClassClicker extends React.Component<any, any>{
    render(){
        return(
            <div>
                <button>This clicks.</button>
            </div>
        );
    }
}