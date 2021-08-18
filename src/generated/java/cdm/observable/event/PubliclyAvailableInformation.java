package cdm.observable.event;

import cdm.observable.event.meta.PubliclyAvailableInformationMeta;
import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaClass

public interface PubliclyAvailableInformation extends RosettaModelObject {
	PubliclyAvailableInformation build();
	PubliclyAvailableInformation.PubliclyAvailableInformationBuilder toBuilder();
	
	/**
	 * A public information source, e.g. a particular newspaper or electronic news service, that may publish relevant information used in the determination of whether or not a credit event has occurred. ISDA 2003 Term: Public Source.
	 */
	List<? extends String> getPublicSource();
	/**
	 * The minimum number of the specified public information sources that must publish information that reasonably confirms that a credit event has occurred. The market convention is two. ISDA 2003 Term: Specified Number.
	 */
	Integer getSpecifiedNumber();
	/**
	 * If this element is specified and set to &#39;true&#39;, indicates that ISDA defined Standard Public Sources are applicable.
	 */
	Boolean getStandardPublicSources();
	final static PubliclyAvailableInformationMeta metaData = new PubliclyAvailableInformationMeta();
	
	@Override
	default RosettaMetaData<? extends PubliclyAvailableInformation> metaData() {
		return metaData;
	} 
			
	static PubliclyAvailableInformation.PubliclyAvailableInformationBuilder builder() {
		return new PubliclyAvailableInformation.PubliclyAvailableInformationBuilderImpl();
	}
	
	default Class<? extends PubliclyAvailableInformation> getType() {
		return PubliclyAvailableInformation.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("publicSource"), String.class, getPublicSource(), this);
		processor.processBasic(path.newSubPath("specifiedNumber"), Integer.class, getSpecifiedNumber(), this);
		processor.processBasic(path.newSubPath("standardPublicSources"), Boolean.class, getStandardPublicSources(), this);
		
	}
	
	
	interface PubliclyAvailableInformationBuilder extends PubliclyAvailableInformation, RosettaModelObjectBuilder {
		PubliclyAvailableInformation.PubliclyAvailableInformationBuilder addPublicSource(String publicSource);
		PubliclyAvailableInformation.PubliclyAvailableInformationBuilder addPublicSource(String publicSource, int _idx);
		PubliclyAvailableInformation.PubliclyAvailableInformationBuilder addPublicSource(List<? extends String> publicSource);
		PubliclyAvailableInformation.PubliclyAvailableInformationBuilder setPublicSource(List<? extends String> publicSource);
		PubliclyAvailableInformation.PubliclyAvailableInformationBuilder setSpecifiedNumber(Integer specifiedNumber);
		PubliclyAvailableInformation.PubliclyAvailableInformationBuilder setStandardPublicSources(Boolean standardPublicSources);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("publicSource"), String.class, getPublicSource(), this);
			processor.processBasic(path.newSubPath("specifiedNumber"), Integer.class, getSpecifiedNumber(), this);
			processor.processBasic(path.newSubPath("standardPublicSources"), Boolean.class, getStandardPublicSources(), this);
			
		}
		
	}
	
	//PubliclyAvailableInformation.PubliclyAvailableInformationImpl
	class PubliclyAvailableInformationImpl implements PubliclyAvailableInformation {
		private final List<? extends String> publicSource;
		private final Integer specifiedNumber;
		private final Boolean standardPublicSources;
		
		protected PubliclyAvailableInformationImpl(PubliclyAvailableInformation.PubliclyAvailableInformationBuilder builder) {
			this.publicSource = ofNullable(builder.getPublicSource()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.specifiedNumber = builder.getSpecifiedNumber();
			this.standardPublicSources = builder.getStandardPublicSources();
		}
		
		@Override
		public List<? extends String> getPublicSource() {
			return publicSource;
		}
		
		@Override
		public Integer getSpecifiedNumber() {
			return specifiedNumber;
		}
		
		@Override
		public Boolean getStandardPublicSources() {
			return standardPublicSources;
		}
		
		@Override
		public PubliclyAvailableInformation build() {
			return this;
		}
		
		@Override
		public PubliclyAvailableInformation.PubliclyAvailableInformationBuilder toBuilder() {
			PubliclyAvailableInformation.PubliclyAvailableInformationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PubliclyAvailableInformation.PubliclyAvailableInformationBuilder builder) {
			ofNullable(getPublicSource()).ifPresent(builder::setPublicSource);
			ofNullable(getSpecifiedNumber()).ifPresent(builder::setSpecifiedNumber);
			ofNullable(getStandardPublicSources()).ifPresent(builder::setStandardPublicSources);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PubliclyAvailableInformation _that = getType().cast(o);
		
			if (!ListEquals.listEquals(publicSource, _that.getPublicSource())) return false;
			if (!Objects.equals(specifiedNumber, _that.getSpecifiedNumber())) return false;
			if (!Objects.equals(standardPublicSources, _that.getStandardPublicSources())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (publicSource != null ? publicSource.hashCode() : 0);
			_result = 31 * _result + (specifiedNumber != null ? specifiedNumber.hashCode() : 0);
			_result = 31 * _result + (standardPublicSources != null ? standardPublicSources.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PubliclyAvailableInformation {" +
				"publicSource=" + this.publicSource + ", " +
				"specifiedNumber=" + this.specifiedNumber + ", " +
				"standardPublicSources=" + this.standardPublicSources +
			'}';
		}
	}
	
	//PubliclyAvailableInformation.PubliclyAvailableInformationBuilderImpl
	class PubliclyAvailableInformationBuilderImpl implements PubliclyAvailableInformation.PubliclyAvailableInformationBuilder {
	
		protected List<String> publicSource = new ArrayList<>();
		protected Integer specifiedNumber;
		protected Boolean standardPublicSources;
	
		public PubliclyAvailableInformationBuilderImpl() {
		}
	
		@Override
		public List<? extends String> getPublicSource() {
			return publicSource;
		}
		
		@Override
		public Integer getSpecifiedNumber() {
			return specifiedNumber;
		}
		
		@Override
		public Boolean getStandardPublicSources() {
			return standardPublicSources;
		}
		
	
		@Override
		public PubliclyAvailableInformation.PubliclyAvailableInformationBuilder addPublicSource(String publicSource) {
			if (publicSource!=null) this.publicSource.add(publicSource);
			return this;
		}
		
		@Override
		public PubliclyAvailableInformation.PubliclyAvailableInformationBuilder addPublicSource(String publicSource, int _idx) {
			getIndex(this.publicSource, _idx, () -> publicSource);
			return this;
		}
		@Override 
		public PubliclyAvailableInformation.PubliclyAvailableInformationBuilder addPublicSource(List<? extends String> publicSources) {
			if (publicSources != null) {
				for (String toAdd : publicSources) {
					this.publicSource.add(toAdd);
				}
			}
			return this;
		}
		
		@Override 
		public PubliclyAvailableInformation.PubliclyAvailableInformationBuilder setPublicSource(List<? extends String> publicSources) {
			if (publicSources == null)  {
				this.publicSource = new ArrayList<>();
			}
			else {
				this.publicSource = publicSources.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public PubliclyAvailableInformation.PubliclyAvailableInformationBuilder setSpecifiedNumber(Integer specifiedNumber) {
			this.specifiedNumber = specifiedNumber==null?null:specifiedNumber;
			return this;
		}
		@Override
		public PubliclyAvailableInformation.PubliclyAvailableInformationBuilder setStandardPublicSources(Boolean standardPublicSources) {
			this.standardPublicSources = standardPublicSources==null?null:standardPublicSources;
			return this;
		}
		
		@Override
		public PubliclyAvailableInformation build() {
			return new PubliclyAvailableInformation.PubliclyAvailableInformationImpl(this);
		}
		
		@Override
		public PubliclyAvailableInformation.PubliclyAvailableInformationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PubliclyAvailableInformation.PubliclyAvailableInformationBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPublicSource()!=null && !getPublicSource().isEmpty()) return true;
			if (getSpecifiedNumber()!=null) return true;
			if (getStandardPublicSources()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PubliclyAvailableInformation.PubliclyAvailableInformationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PubliclyAvailableInformation.PubliclyAvailableInformationBuilder o = (PubliclyAvailableInformation.PubliclyAvailableInformationBuilder) other;
			
			
			merger.mergeBasic(getPublicSource(), o.getPublicSource(), (Consumer<String>) this::addPublicSource);
			merger.mergeBasic(getSpecifiedNumber(), o.getSpecifiedNumber(), this::setSpecifiedNumber);
			merger.mergeBasic(getStandardPublicSources(), o.getStandardPublicSources(), this::setStandardPublicSources);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PubliclyAvailableInformation _that = getType().cast(o);
		
			if (!ListEquals.listEquals(publicSource, _that.getPublicSource())) return false;
			if (!Objects.equals(specifiedNumber, _that.getSpecifiedNumber())) return false;
			if (!Objects.equals(standardPublicSources, _that.getStandardPublicSources())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (publicSource != null ? publicSource.hashCode() : 0);
			_result = 31 * _result + (specifiedNumber != null ? specifiedNumber.hashCode() : 0);
			_result = 31 * _result + (standardPublicSources != null ? standardPublicSources.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PubliclyAvailableInformationBuilder {" +
				"publicSource=" + this.publicSource + ", " +
				"specifiedNumber=" + this.specifiedNumber + ", " +
				"standardPublicSources=" + this.standardPublicSources +
			'}';
		}
	}
}
