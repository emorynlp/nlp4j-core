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
package edu.emory.mathcs.nlp.component.ner.feature;

import edu.emory.mathcs.nlp.component.ner.NERFeatureTemplate;
import edu.emory.mathcs.nlp.component.template.feature.FeatureItem;
import edu.emory.mathcs.nlp.component.template.feature.Field;

/**
 * Default features.
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public class NERFeatureTemplate0 extends NERFeatureTemplate
{
	private static final long serialVersionUID = -3867869616627234917L;

	public NERFeatureTemplate0(int dynamicFeatureSize, int embeddingWindowLeft, int embeddingWindowRight)
	{
		super(dynamicFeatureSize, embeddingWindowLeft, embeddingWindowRight);
	}
	
	@Override
	protected void init()
	{
		// word forms
		add(new FeatureItem<>(-1, Field.simplified_word_form));
		add(new FeatureItem<>( 0, Field.simplified_word_form));
		add(new FeatureItem<>( 1, Field.simplified_word_form));
		
		// uncapitalized word forms
		add(new FeatureItem<>(-2, Field.uncapitalized_simplified_word_form));
		add(new FeatureItem<>(-1, Field.uncapitalized_simplified_word_form));
		add(new FeatureItem<>( 0, Field.uncapitalized_simplified_word_form));
		add(new FeatureItem<>( 1, Field.uncapitalized_simplified_word_form));
		add(new FeatureItem<>( 2, Field.uncapitalized_simplified_word_form));
		
		// word shapes
		add(new FeatureItem<>(-1, Field.word_shape, 2));
		add(new FeatureItem<>( 0, Field.word_shape, 2));
		add(new FeatureItem<>( 1, Field.word_shape, 2));
		
		// lemma
		add(new FeatureItem<>( 0, Field.lemma));

		// part-of-speech tags
		add(new FeatureItem<>(-2, Field.part_of_speech_tag));
		add(new FeatureItem<>(-1, Field.part_of_speech_tag));
		add(new FeatureItem<>( 0, Field.part_of_speech_tag));
		add(new FeatureItem<>( 1, Field.part_of_speech_tag));
		add(new FeatureItem<>( 2, Field.part_of_speech_tag));
		
		// named entity tags
		add(new FeatureItem<>(-3, Field.named_entity_tag));
		add(new FeatureItem<>(-2, Field.named_entity_tag));
		add(new FeatureItem<>(-1, Field.named_entity_tag));

		// named entity gazetteers
		addSet(new FeatureItem<>(-1, Field.named_entity_gazetteers));
		addSet(new FeatureItem<>( 0, Field.named_entity_gazetteers));
		addSet(new FeatureItem<>( 1, Field.named_entity_gazetteers));
		addSet(new FeatureItem<>( 2, Field.named_entity_gazetteers));
		addSet(new FeatureItem<>( 3, Field.named_entity_gazetteers));
				
		// affix features
		add(new FeatureItem<>(-1, Field.suffix, 3));
		add(new FeatureItem<>( 0, Field.prefix, 1));
		add(new FeatureItem<>( 0, Field.suffix, 1));
		add(new FeatureItem<>( 0, Field.suffix, 3));
		add(new FeatureItem<>( 1, Field.prefix, 3));
		
		// orthographic features
		addSet(new FeatureItem<>(0, Field.orthographic));
		addSet(new FeatureItem<>(1, Field.orthographic));

		// word cluster features
//		addSet(new FeatureItem<>(-2, Field.word_clusters));
//		addSet(new FeatureItem<>(-1, Field.word_clusters));
		addSet(new FeatureItem<>( 0, Field.word_clusters));
		addSet(new FeatureItem<>( 1, Field.word_clusters));
		addSet(new FeatureItem<>( 2, Field.word_clusters));
	}
}