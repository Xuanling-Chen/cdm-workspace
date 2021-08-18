package cdm.observable.asset;

import cdm.observable.asset.meta.InformationSourceMeta;
import cdm.observable.asset.metafields.FieldWithMetaInformationProviderEnum;
import cdm.observable.asset.metafields.FieldWithMetaInformationProviderEnum.FieldWithMetaInformationProviderEnumBuilder;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.metafields.FieldWithMetaString;
import com.rosetta.model.metafields.FieldWithMetaString.FieldWithMetaStringBuilder;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A class defining the source for a piece of information (e.g. a rate fix or an FX fixing). The attribute names have been adjusted from FpML to address the fact that the information is not limited to rates.
 * @version ${project.version}
 */
@RosettaClass

public interface InformationSource extends RosettaModelObject {
	InformationSource build();
	InformationSource.InformationSourceBuilder toBuilder();
	
	/**
	 * A specific page for the source for obtaining a market data point. In FpML, this is specified as a scheme, rateSourcePageScheme, for which no coding Scheme or URI is specified.
	 */
	FieldWithMetaString getSourcePage();
	/**
	 * The heading for the source on a given source page.
	 */
	String getSourcePageHeading();
	/**
	 * An information source for obtaining a market data point. For example Bloomberg, Reuters, Telerate, etc.
	 */
	FieldWithMetaInformationProviderEnum getSourceProvider();
	final static InformationSourceMeta metaData = new InformationSourceMeta();
	
	@Override
	default RosettaMetaData<? extends InformationSource> metaData() {
		return metaData;
	} 
			
	static InformationSource.InformationSourceBuilder builder() {
		return new InformationSource.InformationSourceBuilderImpl();
	}
	
	default Class<? extends InformationSource> getType() {
		return InformationSource.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("sourcePageHeading"), String.class, getSourcePageHeading(), this);
		
		processRosetta(path.newSubPath("sourcePage"), processor, FieldWithMetaString.class, getSourcePage());
		processRosetta(path.newSubPath("sourceProvider"), processor, FieldWithMetaInformationProviderEnum.class, getSourceProvider());
	}
	
	
	interface InformationSourceBuilder extends InformationSource, RosettaModelObjectBuilder {
		FieldWithMetaStringBuilder getOrCreateSourcePage();
		FieldWithMetaStringBuilder getSourcePage();
		FieldWithMetaInformationProviderEnumBuilder getOrCreateSourceProvider();
		FieldWithMetaInformationProviderEnumBuilder getSourceProvider();
		InformationSource.InformationSourceBuilder setSourcePage(FieldWithMetaString sourcePage);
		InformationSource.InformationSourceBuilder setSourcePageValue(String sourcePage);
		InformationSource.InformationSourceBuilder setSourcePageHeading(String sourcePageHeading);
		InformationSource.InformationSourceBuilder setSourceProvider(FieldWithMetaInformationProviderEnum sourceProvider);
		InformationSource.InformationSourceBuilder setSourceProviderValue(InformationProviderEnum sourceProvider);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("sourcePageHeading"), String.class, getSourcePageHeading(), this);
			
			processRosetta(path.newSubPath("sourcePage"), processor, FieldWithMetaStringBuilder.class, getSourcePage());
			processRosetta(path.newSubPath("sourceProvider"), processor, FieldWithMetaInformationProviderEnumBuilder.class, getSourceProvider());
		}
		
	}
	
	//InformationSource.InformationSourceImpl
	class InformationSourceImpl implements InformationSource {
		private final FieldWithMetaString sourcePage;
		private final String sourcePageHeading;
		private final FieldWithMetaInformationProviderEnum sourceProvider;
		
		protected InformationSourceImpl(InformationSource.InformationSourceBuilder builder) {
			this.sourcePage = ofNullable(builder.getSourcePage()).map(f->f.build()).orElse(null);
			this.sourcePageHeading = builder.getSourcePageHeading();
			this.sourceProvider = ofNullable(builder.getSourceProvider()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public FieldWithMetaString getSourcePage() {
			return sourcePage;
		}
		
		@Override
		public String getSourcePageHeading() {
			return sourcePageHeading;
		}
		
		@Override
		public FieldWithMetaInformationProviderEnum getSourceProvider() {
			return sourceProvider;
		}
		
		@Override
		public InformationSource build() {
			return this;
		}
		
		@Override
		public InformationSource.InformationSourceBuilder toBuilder() {
			InformationSource.InformationSourceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(InformationSource.InformationSourceBuilder builder) {
			ofNullable(getSourcePage()).ifPresent(builder::setSourcePage);
			ofNullable(getSourcePageHeading()).ifPresent(builder::setSourcePageHeading);
			ofNullable(getSourceProvider()).ifPresent(builder::setSourceProvider);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			InformationSource _that = getType().cast(o);
		
			if (!Objects.equals(sourcePage, _that.getSourcePage())) return false;
			if (!Objects.equals(sourcePageHeading, _that.getSourcePageHeading())) return false;
			if (!Objects.equals(sourceProvider, _that.getSourceProvider())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (sourcePage != null ? sourcePage.hashCode() : 0);
			_result = 31 * _result + (sourcePageHeading != null ? sourcePageHeading.hashCode() : 0);
			_result = 31 * _result + (sourceProvider != null ? sourceProvider.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InformationSource {" +
				"sourcePage=" + this.sourcePage + ", " +
				"sourcePageHeading=" + this.sourcePageHeading + ", " +
				"sourceProvider=" + this.sourceProvider +
			'}';
		}
	}
	
	//InformationSource.InformationSourceBuilderImpl
	class InformationSourceBuilderImpl implements InformationSource.InformationSourceBuilder {
	
		protected FieldWithMetaStringBuilder sourcePage;
		protected String sourcePageHeading;
		protected FieldWithMetaInformationProviderEnumBuilder sourceProvider;
	
		public InformationSourceBuilderImpl() {
		}
	
		@Override
		public FieldWithMetaStringBuilder getSourcePage() {
			return sourcePage;
		}
		
		@Override
		public FieldWithMetaStringBuilder getOrCreateSourcePage() {
			FieldWithMetaStringBuilder result;
			if (sourcePage!=null) {
				result = sourcePage;
			}
			else {
				result = sourcePage = FieldWithMetaString.builder();
			}
			
			return result;
		}
		
		@Override
		public String getSourcePageHeading() {
			return sourcePageHeading;
		}
		
		@Override
		public FieldWithMetaInformationProviderEnumBuilder getSourceProvider() {
			return sourceProvider;
		}
		
		@Override
		public FieldWithMetaInformationProviderEnumBuilder getOrCreateSourceProvider() {
			FieldWithMetaInformationProviderEnumBuilder result;
			if (sourceProvider!=null) {
				result = sourceProvider;
			}
			else {
				result = sourceProvider = FieldWithMetaInformationProviderEnum.builder();
			}
			
			return result;
		}
		
	
		@Override
		public InformationSource.InformationSourceBuilder setSourcePage(FieldWithMetaString sourcePage) {
			this.sourcePage = sourcePage==null?null:sourcePage.toBuilder();
			return this;
		}
		
		@Override
		public InformationSource.InformationSourceBuilder setSourcePageValue(String sourcePage) {
			this.getOrCreateSourcePage().setValue(sourcePage);
			return this;
		}
		@Override
		public InformationSource.InformationSourceBuilder setSourcePageHeading(String sourcePageHeading) {
			this.sourcePageHeading = sourcePageHeading==null?null:sourcePageHeading;
			return this;
		}
		@Override
		public InformationSource.InformationSourceBuilder setSourceProvider(FieldWithMetaInformationProviderEnum sourceProvider) {
			this.sourceProvider = sourceProvider==null?null:sourceProvider.toBuilder();
			return this;
		}
		
		@Override
		public InformationSource.InformationSourceBuilder setSourceProviderValue(InformationProviderEnum sourceProvider) {
			this.getOrCreateSourceProvider().setValue(sourceProvider);
			return this;
		}
		
		@Override
		public InformationSource build() {
			return new InformationSource.InformationSourceImpl(this);
		}
		
		@Override
		public InformationSource.InformationSourceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InformationSource.InformationSourceBuilder prune() {
			if (sourcePage!=null && !sourcePage.prune().hasData()) sourcePage = null;
			if (sourceProvider!=null && !sourceProvider.prune().hasData()) sourceProvider = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getSourcePage()!=null) return true;
			if (getSourcePageHeading()!=null) return true;
			if (getSourceProvider()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InformationSource.InformationSourceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			InformationSource.InformationSourceBuilder o = (InformationSource.InformationSourceBuilder) other;
			
			merger.mergeRosetta(getSourcePage(), o.getSourcePage(), this::setSourcePage);
			merger.mergeRosetta(getSourceProvider(), o.getSourceProvider(), this::setSourceProvider);
			
			merger.mergeBasic(getSourcePageHeading(), o.getSourcePageHeading(), this::setSourcePageHeading);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			InformationSource _that = getType().cast(o);
		
			if (!Objects.equals(sourcePage, _that.getSourcePage())) return false;
			if (!Objects.equals(sourcePageHeading, _that.getSourcePageHeading())) return false;
			if (!Objects.equals(sourceProvider, _that.getSourceProvider())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (sourcePage != null ? sourcePage.hashCode() : 0);
			_result = 31 * _result + (sourcePageHeading != null ? sourcePageHeading.hashCode() : 0);
			_result = 31 * _result + (sourceProvider != null ? sourceProvider.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InformationSourceBuilder {" +
				"sourcePage=" + this.sourcePage + ", " +
				"sourcePageHeading=" + this.sourcePageHeading + ", " +
				"sourceProvider=" + this.sourceProvider +
			'}';
		}
	}
}
