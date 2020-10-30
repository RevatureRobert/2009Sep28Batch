/**
 * @jest-environment jsdom
 * 
 */


import fetchGoogle from './rnetwork';

test('should get back google', () => {
    expect(go()).toContain("google");
})