package cdm.event.workflow;

import cdm.event.workflow.meta.CreditLimitInformationMeta;
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
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A class to represent the credit limit utilisation information.
 * @version ${project.version}
 */
@RosettaClass

public interface CreditLimitInformation extends RosettaModelObject {
	CreditLimitInformation build();
	CreditLimitInformation.CreditLimitInformationBuilder toBuilder();
	
	/**
	 */
	List<? extends LimitApplicableExtended> getLimitApplicable();
	final static CreditLimitInformationMeta metaData = new CreditLimitInformationMeta();
	
	@Override
	default RosettaMetaData<? extends CreditLimitInformation> metaData() {
		return metaData;
	} 
			
	static CreditLimitInformation.CreditLimitInformationBuilder builder() {
		return new CreditLimitInformation.CreditLimitInformationBuilderImpl();
	}
	
	default Class<? extends CreditLimitInformation> getType() {
		return CreditLimitInformation.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("limitApplicable"), processor, LimitApplicableExtended.class, getLimitApplicable());
	}
	
	
	interface CreditLimitInformationBuilder extends CreditLimitInformation, RosettaModelObjectBuilder {
		LimitApplicableExtended.LimitApplicableExtendedBuilder getOrCreateLimitApplicable(int _index);
		List<? extends LimitApplicableExtended.LimitApplicableExtendedBuilder> getLimitApplicable();
		CreditLimitInformation.CreditLimitInformationBuilder addLimitApplicable(LimitApplicableExtended limitApplicable);
		CreditLimitInformation.CreditLimitInformationBuilder addLimitApplicable(LimitApplicableExtended limitApplicable, int _idx);
		CreditLimitInformation.CreditLimitInformationBuilder addLimitApplicable(List<? extends LimitApplicableExtended> limitApplicable);
		CreditLimitInformation.CreditLimitInformationBuilder setLimitApplicable(List<? extends LimitApplicableExtended> limitApplicable);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("limitApplicable"), processor, LimitApplicableExtended.LimitApplicableExtendedBuilder.class, getLimitApplicable());
		}
		
	}
	
	//CreditLimitInformation.CreditLimitInformationImpl
	class CreditLimitInformationImpl implements CreditLimitInformation {
		private final List<? extends LimitApplicableExtended> limitApplicable;
		
		protected CreditLimitInformationImpl(CreditLimitInformation.CreditLimitInformationBuilder builder) {
			this.limitApplicable = ofNullable(builder.getLimitApplicable()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		public List<? extends LimitApplicableExtended> getLimitApplicable() {
			return limitApplicable;
		}
		
		@Override
		public CreditLimitInformation build() {
			return this;
		}
		
		@Override
		public CreditLimitInformation.CreditLimitInformationBuilder toBuilder() {
			CreditLimitInformation.CreditLimitInformationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CreditLimitInformation.CreditLimitInformationBuilder builder) {
			ofNullable(getLimitApplicable()).ifPresent(builder::setLimitApplicable);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditLimitInformation _that = getType().cast(o);
		
			if (!ListEquals.listEquals(limitApplicable, _that.getLimitApplicable())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (limitApplicable != null ? limitApplicable.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditLimitInformation {" +
				"limitApplicable=" + this.limitApplicable +
			'}';
		}
	}
	
	//CreditLimitInformation.CreditLimitInformationBuilderImpl
	class CreditLimitInformationBuilderImpl implements CreditLimitInformation.CreditLimitInformationBuilder {
	
		protected List<LimitApplicableExtended.LimitApplicableExtendedBuilder> limitApplicable = new ArrayList<>();
	
		public CreditLimitInformationBuilderImpl() {
		}
	
		@Override
		public List<? extends LimitApplicableExtended.LimitApplicableExtendedBuilder> getLimitApplicable() {
			return limitApplicable;
		}
		
		public LimitApplicableExtended.LimitApplicableExtendedBuilder getOrCreateLimitApplicable(int _index) {
		
			if (limitApplicable==null) {
				this.limitApplicable = new ArrayList<>();
			}
			LimitApplicableExtended.LimitApplicableExtendedBuilder result;
			return getIndex(limitApplicable, _index, () -> {
						LimitApplicableExtended.LimitApplicableExtendedBuilder newLimitApplicable = LimitApplicableExtended.builder();
						return newLimitApplicable;
					});
		}
		
	
		@Override
		public CreditLimitInformation.CreditLimitInformationBuilder addLimitApplicable(LimitApplicableExtended limitApplicable) {
			if (limitApplicable!=null) this.limitApplicable.add(limitApplicable.toBuilder());
			return this;
		}
		
		@Override
		public CreditLimitInformation.CreditLimitInformationBuilder addLimitApplicable(LimitApplicableExtended limitApplicable, int _idx) {
			getIndex(this.limitApplicable, _idx, () -> limitApplicable.toBuilder());
			return this;
		}
		@Override 
		public CreditLimitInformation.CreditLimitInformationBuilder addLimitApplicable(List<? extends LimitApplicableExtended> limitApplicables) {
			if (limitApplicables != null) {
				for (LimitApplicableExtended toAdd : limitApplicables) {
					this.limitApplicable.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public CreditLimitInformation.CreditLimitInformationBuilder setLimitApplicable(List<? extends LimitApplicableExtended> limitApplicables) {
			if (limitApplicables == null)  {
				this.limitApplicable = new ArrayList<>();
			}
			else {
				this.limitApplicable = limitApplicables.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public CreditLimitInformation build() {
			return new CreditLimitInformation.CreditLimitInformationImpl(this);
		}
		
		@Override
		public CreditLimitInformation.CreditLimitInformationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditLimitInformation.CreditLimitInformationBuilder prune() {
			limitApplicable = limitApplicable.stream().filter(b->b!=null).<LimitApplicableExtended.LimitApplicableExtendedBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getLimitApplicable()!=null && getLimitApplicable().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditLimitInformation.CreditLimitInformationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CreditLimitInformation.CreditLimitInformationBuilder o = (CreditLimitInformation.CreditLimitInformationBuilder) other;
			
			merger.mergeRosetta(getLimitApplicable(), o.getLimitApplicable(), this::getOrCreateLimitApplicable);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditLimitInformation _that = getType().cast(o);
		
			if (!ListEquals.listEquals(limitApplicable, _that.getLimitApplicable())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (limitApplicable != null ? limitApplicable.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditLimitInformationBuilder {" +
				"limitApplicable=" + this.limitApplicable +
			'}';
		}
	}
}
