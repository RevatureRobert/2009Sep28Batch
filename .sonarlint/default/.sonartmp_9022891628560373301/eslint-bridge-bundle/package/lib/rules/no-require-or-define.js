"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.rule = {
    create(context) {
        return {
            'CallExpression[callee.type="Identifier"]': (node) => {
                if (context.getScope().type !== 'module' && context.getScope().type !== 'global') {
                    return;
                }
                const callExpression = node;
                const identifier = callExpression.callee;
                if (isAmdImport(callExpression, identifier) ||
                    isCommonJsImport(callExpression, identifier)) {
                    context.report({
                        node: identifier,
                        message: `Use a standard "import" statement instead of "${identifier.name}".`,
                    });
                }
            },
        };
    },
};
function isCommonJsImport(callExpression, identifier) {
    return callExpression.arguments.length === 1 && identifier.name === 'require';
}
function isAmdImport(callExpression, identifier) {
    if (identifier.name !== 'require' && identifier.name !== 'define') {
        return false;
    }
    if (callExpression.arguments.length !== 2 && callExpression.arguments.length !== 3) {
        return false;
    }
    const lastArgumentType = callExpression.arguments[callExpression.arguments.length - 1].type;
    return (lastArgumentType === 'FunctionExpression' || lastArgumentType === 'ArrowFunctionExpression');
}
//# sourceMappingURL=no-require-or-define.js.map