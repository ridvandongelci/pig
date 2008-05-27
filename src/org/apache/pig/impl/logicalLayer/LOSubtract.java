/* 
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.pig.impl.logicalLayer;

import org.apache.pig.impl.plan.OperatorKey;
import org.apache.pig.impl.plan.PlanVisitor;
import org.apache.pig.impl.plan.VisitorException;
import org.apache.pig.impl.logicalLayer.schema.Schema;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class LOSubtract extends BinaryExpressionOperator {

    private static final long serialVersionUID = 2L;
    private static Log log = LogFactory.getLog(LOSubtract.class);

    /**
     * 
     * @param plan
     *            Logical plan this operator is a part of.
     * @param k
     *            Operator key to assign to this node.
     * @param lhsOperand
     *            the left hand side operand
     * @param rhsOperand
     *            the right hand side operand
     */
    public LOSubtract(LogicalPlan plan, OperatorKey k,
            ExpressionOperator lhsOperand, ExpressionOperator rhsOperand) {
        super(plan, k, lhsOperand, rhsOperand);
    }

    @Override
    public Schema getSchema() {
        return mSchema;
    }

    @Override
    public Schema.FieldSchema getFieldSchema() {
        // TODO When tuple subtraction is implemented, getSchema should
        // compute the schema, store the computed schema and return
        // the computed schema

        return mFieldSchema;
    }

    @Override
    public void visit(LOVisitor v) throws VisitorException {
        v.visit(this);
    }

    @Override
    public String name() {
        return "Subtract " + mKey.scope + "-" + mKey.id;
    }
}
