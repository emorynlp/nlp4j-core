/**
 * Copyright 2015, Emory University
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package edu.emory.mathcs.nlp.component.pos.feature;

import edu.emory.mathcs.nlp.component.pos.POSFeatureTemplate;
import edu.emory.mathcs.nlp.component.template.feature.FeatureItem;
import edu.emory.mathcs.nlp.component.template.feature.Field;

/**
 * Default features.
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public class POSFeatureTemplate2 extends POSFeatureTemplate
{
	private static final long serialVersionUID = 7072878555553683666L;

	public POSFeatureTemplate2(int dynamicFeatureSize, int embeddingWindowLeft, int embeddingWindowRight)
	{
		super(dynamicFeatureSize, embeddingWindowLeft, embeddingWindowRight);
	}
	
	@Override
	protected void init()
	{
		// 1-gram features 
		add(new FeatureItem<>(-2, Field.simplified_word_form));
		add(new FeatureItem<>(-1, Field.simplified_word_form));
		add(new FeatureItem<>( 0, Field.simplified_word_form));
		add(new FeatureItem<>( 1, Field.simplified_word_form));
		add(new FeatureItem<>( 2, Field.simplified_word_form));

		add(new FeatureItem<>(-1, Field.word_shape, 2));
		add(new FeatureItem<>( 0, Field.word_shape, 2));
		add(new FeatureItem<>( 1, Field.word_shape, 2));

		add(new FeatureItem<>(-3, Field.part_of_speech_tag));
		add(new FeatureItem<>(-2, Field.part_of_speech_tag));
		add(new FeatureItem<>(-1, Field.part_of_speech_tag));
		
		add(new FeatureItem<>( 0, Field.ambiguity_classes));
		add(new FeatureItem<>( 1, Field.ambiguity_classes));
		add(new FeatureItem<>( 2, Field.ambiguity_classes));
		add(new FeatureItem<>( 3, Field.ambiguity_classes));

		// 2-gram features
		add(new FeatureItem<>(-2, Field.uncapitalized_simplified_word_form), new FeatureItem<>(-1, Field.uncapitalized_simplified_word_form));
		add(new FeatureItem<>(-1, Field.uncapitalized_simplified_word_form), new FeatureItem<>( 0, Field.uncapitalized_simplified_word_form));
		add(new FeatureItem<>( 0, Field.uncapitalized_simplified_word_form), new FeatureItem<>( 1, Field.uncapitalized_simplified_word_form));
		add(new FeatureItem<>( 1, Field.uncapitalized_simplified_word_form), new FeatureItem<>( 2, Field.uncapitalized_simplified_word_form));
		add(new FeatureItem<>(-1, Field.uncapitalized_simplified_word_form), new FeatureItem<>( 1, Field.uncapitalized_simplified_word_form));

		add(new FeatureItem<>(-2, Field.part_of_speech_tag), new FeatureItem<>(-1, Field.part_of_speech_tag));
		add(new FeatureItem<>(-1, Field.part_of_speech_tag), new FeatureItem<>( 1, Field.ambiguity_classes));
		add(new FeatureItem<>( 1, Field.ambiguity_classes)   , new FeatureItem<>( 2, Field.ambiguity_classes));

		// 3-gram features
		add(new FeatureItem<>(-2, Field.part_of_speech_tag), new FeatureItem<>(-1, Field.part_of_speech_tag), new FeatureItem<>( 0, Field.ambiguity_classes));
		add(new FeatureItem<>(-2, Field.part_of_speech_tag), new FeatureItem<>(-1, Field.part_of_speech_tag), new FeatureItem<>( 1, Field.ambiguity_classes));
		add(new FeatureItem<>(-1, Field.part_of_speech_tag), new FeatureItem<>( 0, Field.ambiguity_classes)   , new FeatureItem<>( 1, Field.ambiguity_classes));
		add(new FeatureItem<>(-1, Field.part_of_speech_tag), new FeatureItem<>( 1, Field.ambiguity_classes)   , new FeatureItem<>( 2, Field.ambiguity_classes));

		// affix features
		add(new FeatureItem<>(0, Field.prefix, 2));
		add(new FeatureItem<>(0, Field.prefix, 3));
		add(new FeatureItem<>(0, Field.suffix, 1));
		add(new FeatureItem<>(0, Field.suffix, 2));
		add(new FeatureItem<>(0, Field.suffix, 3));
		add(new FeatureItem<>(0, Field.suffix, 4));
		
		// orthographic features
		addSet(new FeatureItem<>(0, Field.orthographic));
		
		// boolean features
		addSet(new FeatureItem<>(0, Field.positional));
		
		// word cluster features
		addSet(new FeatureItem<>(-1, Field.word_clusters));
		addSet(new FeatureItem<>( 0, Field.word_clusters));
		addSet(new FeatureItem<>( 1, Field.word_clusters));
	}
}