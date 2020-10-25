/**
 * @jest-environment jsdom
 */

import fetchGoogle from './network';

test("should get back Google", async () => {
    expect(await fetchGoogle()).toContain("google");
});